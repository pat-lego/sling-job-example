package com.adobe.aem.core.queue.jmx.cqsupport;

import com.adobe.granite.jmx.annotation.Description;

@Description("MBean to log a message to the cqsupport/job/topic")
public interface CQSupportJobMBean {

    @Description("Provide the message to log to the consumer")
    void logMessage(String message);

}