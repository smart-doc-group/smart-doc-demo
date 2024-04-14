
native:
	mvn -Dmaven.test.skip=true -Pnative native:compile

image:
	mvn spring-boot:build-image

docker-build:
	docker build --platform linux/amd64 -t registry.cn-hangzhou.aliyuncs.com/shalousun/smart-doc-demo:latest  .

generate-doc:
	mvn -Dmaven.test.skip=true -Dfile.encoding=UTF-8  smart-doc:html

# generate jmeter script
generate-jmeter:
	mvn -Dfile.encoding=UTF-8  smart-doc:jmeter