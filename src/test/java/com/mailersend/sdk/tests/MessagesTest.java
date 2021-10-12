/*************************************************
 * MailerSend Java SDK
 * https://github.com/mailersend/mailersend-java
 * 
 * @author MailerSend <support@mailersend.com>
 * https://mailersend.com
 **************************************************/
package com.mailersend.sdk.tests;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.mailersend.sdk.MailerSend;
import com.mailersend.sdk.exceptions.MailerSendException;
import com.mailersend.sdk.messages.Message;
import com.mailersend.sdk.messages.MessagesList;
import com.mailersend.sdk.messages.MessagesListItem;

public class MessagesTest {

    /**
     * Gets a lists of messages
     */
    @Test
    public void TestMessagesRetrieval() {
        
        MailerSend ms = new MailerSend();
        ms.setToken(TestHelper.validToken);
        
        try {
            
            MessagesList list = ms.messages().getMessages();
            
            System.out.println("\n\nMessages:");
            for (MessagesListItem item : list.messages) {
                
                System.out.println(item.id);
            }

        } catch (MailerSendException e) {
            
            fail();
        }
    }
    
    
    /**
     * Tests a single message retrieval
     */
    @Test
    public void TestSingleMessage() {
        
        // get a single message first
        MailerSend ms = new MailerSend();
        ms.setToken(TestHelper.validToken);
        
        try {
            
            MessagesList list = ms.messages().getMessages();
            
            if (list.messages.length == 0) {
                
                fail();
            }
            
            Message message = ms.messages().getMessage(list.messages[0].id);
            
            System.out.println("\n\nMessage:");
            System.out.println(message.id);
            System.out.println(message.domain.name);

        } catch (MailerSendException e) {
            
            fail();
        }
    }
    
}
