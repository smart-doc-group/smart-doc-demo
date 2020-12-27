Documenting a Spring REST API Using Smart-doc
# Overview
Documentation is an essential part of building REST APIs.
In this tutorial, we'll take a look at Smart-Doc — a tool that simplifies the generation and maintenance of API docs.
# Add Maven Plugin
The smart-doc library provides a Maven plugin smart-doc-maven-plugin for generating Markdown/HTML5/Asciidoctor/Postman Collection 2.0+/OpenAPI 3.0 docs for our API,

Let's see how we can configure the plugin in our pom.xml:
```
<plugin>
    <groupId>com.github.shalousun</groupId>
    <artifactId>smart-doc-maven-plugin</artifactId>
    <version>2.0.2</version>
    <configuration>
        <!--smart-doc-->
        <configFile>./src/main/resources/smart-doc.json</configFile>
        <!--Exclude jars that fail to load third-party dependent source code-->
        <excludes>
            <!--The format is: groupId: artifactId; refer to the following-->
            <exclude>com.alibaba:fastjson</exclude>
        </excludes>
    </configuration>
    <executions>
        <execution>
            <!--Comment out phase if you don't need to start smart-doc when compiling-->
            <phase>compile</phase>
            <goals>
                <goal>html</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```
## Integrating springdoc-openapi
smart-doc could generate  OpenAPI 3 specification for our APIs.
We can integrate springdoc-openapi and Swagger UI in a Spring WebFlux project by adding springdoc-openapi-webflux-ui,
Then use Swagger UI to view OpenAPI 3 specification docs.
```
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-ui</artifactId>
    <version>1.5.0</version>
</dependency>
```

In order to customize the openapi
```
# custom path for swagger-ui
springdoc:
  swagger-ui:
    path: /swagger-ui-custom.html
    operations-sorter: method
   #custom path for api docs
    url: /doc/openapi.json
#  api-docs:
#    path: /api-docs
```
The docs will be accessible at:
```
http://localhost:8080/swagger-ui.html
```
## Conclusion
In this article, we learned to use the smart-doc Maven Plugin to generate Markdown/HTML5/Asciidoctor/Postman Collection 2.0+/OpenAPI 3.0 for our APIs.

As always, the code is available [over on GitHub](https://github.com/shalousun/smart-doc-demo).