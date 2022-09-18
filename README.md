This is a project that acts as a PoT (proof of technology) for Splunk HEC logging with the Logback API.

The library used is:
https://github.com/splunk/splunk-library-javalogging

There are 2 endpoints:
- /send: Randomly sends logging statements to a Logger instance that is configured to use the Splunk HEC appender.
- /services/collector/event/1.0: This mimics the Splunk server HEC endpoint just to have a look at the payload sent.

To easily fire requests, just use Curl in a Git Bash console in Windows:
curl http://localhost:8080/send

The logback.xml file has the Splunk HEC appender configuration that is based on the splunk-library-javalogging template.
