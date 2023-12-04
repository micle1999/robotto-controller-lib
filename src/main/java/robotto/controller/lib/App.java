package robotto.controller.lib;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
      //eventPublisher.publishTestEvent();
      System.out.println("APP START");
   }
}
