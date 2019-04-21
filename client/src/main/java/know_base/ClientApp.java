package know_base;

import know_base.services.KnowBaseServiceClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ClientApp {



    public static void main(String[] args) {
        SpringApplication.run(ClientApp.class, args);

        KnowBaseServiceClient client = new KnowBaseServiceClient();
        client.addRecord("Test", "Test");
        client.addRecord("Test", "Test");
        client.addRecord("Test", "Test");
    }

}