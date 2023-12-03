package robotto.controller.lib.EventStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import robotto.controller.lib.Models.Events.DroneTelemetry;

@Service
public class EventPublisher {
    
    @Autowired
    private AmqpTemplate rabbitTemplate;
    
    @Autowired
    private Queue queue;

    private static Logger logger = LogManager.getLogger(EventPublisher.class.toString());

    public void publishTelemetry(DroneTelemetry telemetry) {
        rabbitTemplate.convertAndSend(queue.getName(), telemetry); // add telemetry routingKey
        logger.info("Sending Telemetry Message to the Queue : " + telemetry.toString());
    }
}