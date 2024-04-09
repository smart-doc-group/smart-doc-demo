package com.smartdoc.example.exception;

import com.smartdoc.example.response.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * Global RestException
 */
@RestControllerAdvice
public class RestExceptionHandler {

    /**
     * log
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseResult illegalParamsExceptionHandler(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        FieldError fieldError = bindingResult.getFieldError();
        LOGGER.error("request params invalid: {}", fieldError.getDefaultMessage());
        return processBindingError(fieldError);
    }

    @ExceptionHandler(value = {MethodArgumentTypeMismatchException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseResult methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        String error = String.format("The parameter '%s' should be of type '%s'", ex.getName(), ex.getRequiredType().getSimpleName());
        return ResponseResult.fail("400", error);
    }

    @ExceptionHandler(value = {NoHandlerFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseResult noHandlerFoundException(Exception ex) {
        return ResponseResult.fail("404", "Resource Not Found");
    }

    @ExceptionHandler(value = {HttpMediaTypeNotSupportedException.class})
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    public ResponseResult handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex) {
        StringBuilder builder = new StringBuilder();
        builder.append(ex.getContentType());
        builder.append(" media type is not supported. Supported media types are ");
        ex.getSupportedMediaTypes().forEach(t -> builder.append(t).append(","));
        return ResponseResult.fail("415", builder.toString());
    }

    @ExceptionHandler(value = {HttpRequestMethodNotSupportedException.class})
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public ResponseResult methodNotSupportedException(HttpRequestMethodNotSupportedException ex) {
        LOGGER.error("Error code 405: {}", ex.getMessage());
        return ResponseResult.fail("405", ex.getMessage());
    }

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseResult unknownException(Exception ex) {
        LOGGER.error("Error code 500：{}", ex);
        return ResponseResult.fail("500", ex.getMessage());
    }


    /**
     * spring binding error
     *
     * @param fieldError
     * @return
     */
    private ResponseResult processBindingError(FieldError fieldError) {
        String code = fieldError.getCode();
        LOGGER.debug("validator error code: {}", code);
        switch (code) {
            case "NotEmpty":
            case "NotBlank":
            case "NotNull":
            case "Pattern":
            case "Min":
            case "Max":
            case "Length":
            case "Range":
            case "Email":
            case "DecimalMin":
            case "DecimalMax":
            case "Size":
            case "Digits":
            case "Past":
            case "Future":
                return ResponseResult.fail("400", fieldError.getDefaultMessage());
            default:
                return ResponseResult.fail("400","unknown error");
        }
    }
}
