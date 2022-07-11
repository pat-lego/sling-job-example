package com.adobe.aem.core.queue.provider;

public interface CQSupportJobProvider {

    static final String TOPIC = "cqsupport/job/topic";
    static final String LOG_MESSAGE = "logmessage";
    
    public void startJob(String logMessage);

}