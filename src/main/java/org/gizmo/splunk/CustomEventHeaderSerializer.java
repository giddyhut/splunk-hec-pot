package org.gizmo.splunk;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.splunk.logging.EventHeaderSerializer;
import com.splunk.logging.HttpEventCollectorEventInfo;

import java.util.HashMap;
import java.util.Map;

public class CustomEventHeaderSerializer implements EventHeaderSerializer {
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Map<String, Object> serializeEventHeader(
            HttpEventCollectorEventInfo httpEventCollectorEventInfo, Map<String, Object> map) {
        Map<String, Object> m = new HashMap<>(map);
        MessageDto messageDto = null;
        try {
            messageDto = objectMapper.readValue(httpEventCollectorEventInfo.getMessage(), MessageDto.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        m.put("userId", messageDto.getUserId());
        m.put("mobileNo", messageDto.getMobileNo());
        m.put("email", messageDto.getEmail());
        m.put("msg", messageDto.getMessage());
        return m;
    }
}
