package org.gizmo.splunk;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageDto {

    private String userId;
    private String mobileNo;
    private String email;
    private String message;
}
