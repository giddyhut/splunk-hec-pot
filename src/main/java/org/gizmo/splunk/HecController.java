package org.gizmo.splunk;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * https://docs.splunk.com/Documentation/Splunk/9.0.1/Data/HECExamples
 * curl https://hec.example.com:8088/services/collector/event -H "Authorization: Splunk B5A79AAD-D822-46CC-80D1-819F80D7BFB0" -d '{"event": "hello world"}'
 * {"text": "Success", "code": 0}
 */
@RestController
@Slf4j
public class HecController {

    ObjectMapper objectMapper = new ObjectMapper();
    Faker faker = new Faker();

    /**
     * To emulate Splunk endpoint, splunk-library-javalogging actually sends to /1.0,
     * different from online docs
     */
    @PostMapping(path = "/services/collector/event/1.0")
    public ResponseEntity<?> getHecEvents(@RequestBody String requestBody) {
        log.info("Received: {}", requestBody);
        return ResponseEntity.ok(new HecResponseDto("Success", 0));
    }

    @GetMapping(path = "/send")
    public ResponseEntity<?> sendEvents() throws Exception {
        String s = faker.lordOfTheRings().location();
        log.info("Sending: {}", s);
        Logger splunker = LoggerFactory.getLogger("splunk.logger");
        MDC.put("app", "splunk");
        MDC.put("version", "1.9394");
        MDC.put("system", "shock");
        MessageDto m = new MessageDto("user5354", "7552525", "abc@xyz.com", s);
        splunker.info("{}", objectMapper.writeValueAsString(m));
        return ResponseEntity.ok(s);
    }


}
