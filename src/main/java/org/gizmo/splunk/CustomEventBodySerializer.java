package org.gizmo.splunk;

import com.splunk.logging.EventBodySerializer;
import com.splunk.logging.HttpEventCollectorEventInfo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomEventBodySerializer implements EventBodySerializer {

    @Override
    public String serializeEventBody(HttpEventCollectorEventInfo httpEventCollectorEventInfo, Object o) {
        log.info("Object instanceof: {}", o.getClass());
        return String.valueOf(o);
    }

    @Override
    public double getEventTime(HttpEventCollectorEventInfo eventInfo) {
        return EventBodySerializer.super.getEventTime(eventInfo);
    }
}
