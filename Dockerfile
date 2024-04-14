FROM registry.cn-hangzhou.aliyuncs.com/shalousun/alpine-openjdk17:1.0.0

MAINTAINER shalousun
EXPOSE 8080

# install Spring Boot artifact
VOLUME /tmp
ADD target/smart-doc-demo.jar smart-doc-demo.jar

# set jvm
ENV JAVA_OPTS="-server -Xmx512m -Xms256m -XX:+UseZGC -Djava.awt.headless=true"
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /smart-doc-demo.jar
