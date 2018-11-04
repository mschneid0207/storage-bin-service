package de.bmw.aw.storagebinservice.rabbitmq;

import de.bmw.aw.storagebinservice.business.StorageBinService;
import de.bmw.aw.storagebinservice.model.StorageBin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class RabbitMqConsumer {

    @Autowired
    private StorageBinService storageBinService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private DirectExchange directExchange;

    @RabbitListener(queues = "storage-bin-request.queue")
    public void freeStorageBin() {
        System.out.println(" [x] Received request for free storage bin");
        StorageBin freeStorageBin = storageBinService.findStorageBinById(1000L);
        rabbitTemplate.convertAndSend(directExchange.getName(), "storage-bin-response.route", freeStorageBin);
    }
}
