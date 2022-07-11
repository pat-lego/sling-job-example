package com.adobe.aem.core.queue.consumer;

import org.apache.sling.event.jobs.Job;
import org.apache.sling.event.jobs.consumer.JobConsumer;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.aem.core.queue.provider.CQSupportJobProvider;

@Component(immediate = true, service = JobConsumer.class, property = {
        JobConsumer.PROPERTY_TOPICS + "=" + CQSupportJobProvider.TOPIC
})
public class SimpleCQSupportJobConsumer implements JobConsumer {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public JobResult process(Job job) {

        String logMessage = job.getProperty(CQSupportJobProvider.LOG_MESSAGE, String.class);

        if (logMessage.isEmpty()) {
            logger.info("The job provider provided an empty string to log");
        } else {
            logger.info("The job provided wanted to log the following message {}", logMessage);
        }

        return JobResult.OK;
    }

    @Activate
    public void active() {
        logger.info("The {} job consumer is active", CQSupportJobProvider.TOPIC);
    }

    @Deactivate
    public void deactive() {
        logger.info("The {} job consumer is inactive", CQSupportJobProvider.TOPIC);
    }

}
