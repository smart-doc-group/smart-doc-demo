<h1 align="center">smart-doc-demo</h1>

## Introduce
smart-doc tutorial,Learn how to create `RESTful API` documents with smart-doc.
## Technical selection

- `SpringBoot 3.0.0+`—Used to create a simple `RESTful API`
- `smart-doc`—API document creation tool
- `Docker Compose` - Used for running performance stress test cases
## Build API document
```
mvn smart-doc:html
```
## Build and Run the Project
```
mvn package
```
The app will start running at http://localhost:8080.

Access API documents http://localhost:8080/doc/index.html.

## JMeter Performance Test
Before running the performance stress test cases, you need to install `Docker` and `Docker Compose`.
Of course, if you have a `Kubernetes` cluster, you can also convert the `Docker Compose` template into a `Kubernetes` template to deploy and run the test case.

Generate JMeter script
```
mvn -Dmaven.test.skip=true -Dfile.encoding=UTF-8  smart-doc:jmeter
// or 
make generate-jmeter
```
Run JMeter Performance Test
```
make run-jmeter-performance
```
Stop JMeter Performance Test
```
make down-jmeter-performance
```
The use case scenario involves using `Prometheus` and `Grafana` to monitor the performance testing process, 
which will involve starting `Prometheus`, `Grafana`, and `JMeter`.

- Prometheus http://localhost:9090
- Grafana http://localhost:3000
- JMeter Metrics http://localhost:9270
- Smart-doc-demo http://localhost:8089/doc/index.html

## Reference
- [smart-doc manual](https://github.com/smart-doc-group/smart-doc/)
- [smart-doc-maven plugin manual](https://github.com/smart-doc-group/smart-doc-maven-plugin)

