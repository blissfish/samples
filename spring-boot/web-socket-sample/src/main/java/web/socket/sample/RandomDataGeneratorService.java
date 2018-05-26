package web.socket.sample;

import java.util.Random;

import org.fluttercode.datafactory.NameDataValues;
import org.fluttercode.datafactory.impl.DataFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.core.MessageSendingOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class RandomDataGeneratorService {

	private static final Logger log = LoggerFactory.getLogger(RandomDataGeneratorService.class);

	private final DataFactory df;
    private final MessageSendingOperations<String> messagingTemplate;

    @Autowired
    public RandomDataGeneratorService(
        final MessageSendingOperations<String> messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
        this.df = new DataFactory();
    }  

    @Scheduled(fixedDelay = 100)
    public void sendDataUpdates() {
    	Integer random = df.getNumberBetween(0, 100);
    	log.info("Created Random "+random);
        this.messagingTemplate.convertAndSend(
            "/topic/numbers", random);

    }
    
    
}