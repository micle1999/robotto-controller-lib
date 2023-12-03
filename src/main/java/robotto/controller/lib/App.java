package robotto.controller.lib;

import org.springframework.beans.factory.annotation.Autowired;

import robotto.controller.lib.BlobStorage.Interfaces.BlobStorageService;
import robotto.controller.lib.CosmosDb.Interfaces.CosmosDbService;
import robotto.controller.lib.EventStream.EventPublisher;

@SpringBootApplication
public class App implements CommandLineRunner {

   public static void main(String[] args) {
      SpringApplication.run(App.class, args);
   }

   @Autowired
   EventPublisher eventPublisher;


   @Override
   public void run(String... args) {
      publisher.publishTestEvent();
   }
}
