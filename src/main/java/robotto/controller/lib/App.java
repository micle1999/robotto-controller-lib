package robotto.controller.lib;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import robotto.controller.lib.BlobStorage.BlobStorageService;
import robotto.controller.lib.EventStream.EventPublisher;
import robotto.controller.lib.Models.BlobStorage.Resource;

@SpringBootApplication
public class App implements CommandLineRunner {

   public static void main(String[] args) {
      SpringApplication.run(App.class, args);
   }

   @Autowired
   EventPublisher eventPublisher;

   @Autowired
   BlobStorageService blobService;

   @Override
   public void run(String... args) {
      System.out.println("APP START");
   }
}
