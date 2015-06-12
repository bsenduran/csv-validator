package org.wso2.sen;

import org.apache.axis2.AxisFault;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.synapse.MessageContext;
import org.apache.synapse.SynapseException;
import org.apache.synapse.mediators.AbstractMediator;

public class CSVValidator extends AbstractMediator  {

    protected Log log = LogFactory.getLog(this.getClass());

    @Override
    public boolean mediate(MessageContext messageContext){

        log.info("hello world");
        log.info(messageContext.getEnvelope().getBody().toString());

        String csvText = messageContext.getEnvelope().getBody().getFirstElement().getText();
        String[] csvrows = csvText.split("\\n");

        String validRegex = "^([a-z]+)\\|(\\d)+\\|([a-z]+)\\|([a-z]+)$";

        for (String row:csvrows) {
log.info(row);
            log.info("\r\n");
            if(!row.matches(validRegex)) {
               throw new SynapseException("CSV validation failed");
            }

        }
        return true;
    }
}
