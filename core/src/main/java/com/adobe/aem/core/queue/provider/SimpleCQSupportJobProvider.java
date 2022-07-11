package com.adobe.aem.core.queue.provider;

import java.util.HashMap;
import java.util.Map;

import org.apache.sling.event.jobs.JobManager;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(immediate = true)
public class SimpleCQSupportJobProvider implements CQSupportJobProvider {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Reference
    private JobManager jobManager;

    @Override
    public void startJob(String logMessage) {
        Map<String, Object> jobProps = new HashMap<String, Object>();
        if (null != logMessage) {
            jobProps.put(LOG_MESSAGE, logMessage);
            this.jobManager.addJob(TOPIC, jobProps);
        }

    }

    @Activate
    public void activate() {
        this.logger.info("The {} queue is active", TOPIC);
    }

    @Deactivate
    public void deactivate() {
        this.logger.info("The {} queue is inactive", TOPIC);
    }

}
