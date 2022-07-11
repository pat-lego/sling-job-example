package com.adobe.aem.core.queue.jmx.cqsupport;

import javax.management.DynamicMBean;
import javax.management.NotCompliantMBeanException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.adobe.aem.core.queue.provider.CQSupportJobProvider;
import com.adobe.granite.jmx.annotation.AnnotatedStandardMBean;

@Component(immediate = true, service = DynamicMBean.class, property = {
    "jmx.objectname=com.adobe.aem.core.queue.jmx.cqsupport:type=JobManager"
})
public class SimpleCQSupportJobMean extends AnnotatedStandardMBean implements CQSupportJobMBean {

    @Reference
    private CQSupportJobProvider cqSupportJobProvider;

    public SimpleCQSupportJobMean() throws NotCompliantMBeanException {
        super(CQSupportJobMBean.class);
    }

    @Override
    public void logMessage(String message) {  
        this.cqSupportJobProvider.startJob(message);
    }
    
}
