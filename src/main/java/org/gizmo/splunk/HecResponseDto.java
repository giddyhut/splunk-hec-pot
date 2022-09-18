package org.gizmo.splunk;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class HecResponseDto {
    private String text;
    private int code;
}
