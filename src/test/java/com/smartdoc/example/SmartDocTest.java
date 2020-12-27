package com.smartdoc.example;

import com.power.common.util.DateTimeUtil;
import com.power.doc.builder.HtmlApiDocBuilder;
import com.power.doc.model.ApiErrorCodeDictionary;
import com.smartdoc.example.enums.ErrorCodeEnum;
import com.power.doc.model.ApiConfig;
import com.power.doc.constants.DocGlobalConstants;
import com.power.doc.model.CustomRespField;
import com.power.doc.model.SourceCodePath;
import org.junit.Test;

/**
 * @link https://github.com/shalousun/smart-doc.git
 * @author yu on 2020/12/27.
 */
public class SmartDocTest {

   /**
    *  create api-doc
    */
   @Test
   public void testBuilderControllersApi() {
       ApiConfig config = new ApiConfig();
       config.setStrict(true);
       config.setAllInOne(true);
       config.setOutPath(DocGlobalConstants.HTML_DOC_OUT_PATH);
       // set java source path
       config.setSourceCodePaths(
               SourceCodePath.builder().setDesc("current project").setPath("src/main/java")
       );

       // change field
       config.setCustomResponseFields(
               CustomRespField.builder().setName("code").setValue("00000")
       );

       // set error code list
       config.setErrorCodeDictionaries(
               ApiErrorCodeDictionary.builder()
                       .setEnumClass(ErrorCodeEnum.class)
                       .setCodeField("code")
                       .setDescField("desc")
       );

       long start = System.currentTimeMillis();
       HtmlApiDocBuilder.buildApiDoc(config);
       long end = System.currentTimeMillis();
       DateTimeUtil.printRunTime(end, start);
   }
}
