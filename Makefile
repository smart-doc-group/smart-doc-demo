
native:
	mvn -Dmaven.test.skip=true -Pnative native:compile

image:
	mvn spring-boot:build-image