/*************************************************
 * MailerSend Java SDK
 * https://github.com/mailersend/mailersend-java
 * 
 * @author MailerSend <support@mailersend.com>
 * https://mailersend.com
 **************************************************/
package com.mailersend.sdk.tokens;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

import com.google.gson.annotations.SerializedName;
import com.mailersend.sdk.MailerSendResponse;

public class TokenAdd {

    @SerializedName("id")
    public String id;
    
    @SerializedName("accessToken")
    public String accessToken;
    
    @SerializedName("name")
    public String name;
    
    @SerializedName("created_at")
    private String createdAtStr;
    
    public Date createdAt;
    
    
    
    /**
     * Is called to perform any actions after the deserialization of the response
     * Do not call directly
     */
    protected void postDeserialize() {
        
        parseDates();
    }
    
    
    /**
     * Parses the string dates from the response into java.util.Date objects
     */
    private void parseDates() {
        
        TemporalAccessor ta;
        Instant instant;
        
        if (createdAtStr != null && !createdAtStr.isBlank()) {
            
            ta = DateTimeFormatter.ISO_INSTANT.parse(createdAtStr);
            instant = Instant.from(ta);
            createdAt = Date.from(instant);
        }
    }
}
