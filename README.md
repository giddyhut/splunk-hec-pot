This is a project that acts as a PoT (proof of technology) for Splunk HEC logging with the Logback API.

The library used is:
https://github.com/splunk/splunk-library-javalogging

There are 2 endpoints:
- /send: Randomly sends logging statements to a Logger instance that is configured to use the Splunk HEC appender.
- /services/collector/event/1.0: This mimics the Splunk server HEC endpoint just to have a look at the payload sent.

To easily fire requests, just use Curl in a Git Bash console in Windows:
curl http://localhost:8080/send

The logback.xml file has the Splunk HEC appender configuration that is based on the splunk-library-javalogging template.

Sample console output:

2022-09-18 11:14:48.867 INFO  [http-nio-8080-exec-6] org.gizmo.splunk.HecController.getHecEvents - Received: {"msg":"Dome of Stars","sourcetype":"battlecat","source":"splunktest","mobileNo":"7552525","fields":{"messageFormat":"text"},"event":"{\"userId\":\"user5354\",\"mobileNo\":\"7552525\",\"email\":\"abc@xyz.com\",\"message\":\"Dome of Stars\"}","userId":"user5354","email":"abc@xyz.com"}
2022-09-18 11:14:55.220 INFO  [http-nio-8080-exec-8] org.gizmo.splunk.HecController.sendEvents - Sending: Luthany
2022-09-18 11:14:55.232 INFO  [http-nio-8080-exec-8] o.g.splunk.CustomEventBodySerializer.info - Object instanceof: class java.lang.String
2022-09-18 11:14:55.288 INFO  [http-nio-8080-exec-9] org.gizmo.splunk.HecController.getHecEvents - Received: {"msg":"Luthany","sourcetype":"battlecat","source":"splunktest","mobileNo":"7552525","fields":{"messageFormat":"text"},"event":"{\"userId\":\"user5354\",\"mobileNo\":\"7552525\",\"email\":\"abc@xyz.com\",\"message\":\"Luthany\"}","userId":"user5354","email":"abc@xyz.com"}
2022-09-18 11:15:03.412 INFO  [http-nio-8080-exec-5] org.gizmo.splunk.HecController.sendEvents - Sending: Old Forest Road
2022-09-18 11:15:03.413 INFO  [http-nio-8080-exec-5] o.g.splunk.CustomEventBodySerializer.info - Object instanceof: class java.lang.String
2022-09-18 11:15:03.425 INFO  [http-nio-8080-exec-2] org.gizmo.splunk.HecController.getHecEvents - Received: {"msg":"Old Forest Road","sourcetype":"battlecat","source":"splunktest","mobileNo":"7552525","fields":{"messageFormat":"text"},"event":"{\"userId\":\"user5354\",\"mobileNo\":\"7552525\",\"email\":\"abc@xyz.com\",\"message\":\"Old Forest Road\"}","userId":"user5354","email":"abc@xyz.com"}
