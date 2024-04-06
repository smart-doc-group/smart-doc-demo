
native:
	mvn -Dmaven.test.skip=true -Pnative native:compile

image:
	mvn spring-boot:build-image

generate-doc:
	mvn -Dfile.encoding=UTF-8  smart-doc:html

# generate jmeter script
generate-jmeter:
	mvn -Dfile.encoding=UTF-8  smart-doc:jmeter