package know_base;

import know_base.services.KnowBaseServiceClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@EnableScheduling
public class ClientApp {



    public static void main(String[] args) {
        SpringApplication.run(ClientApp.class, args);

        KnowBaseServiceClient client = new KnowBaseServiceClient();
        BigInteger id = client.addRecord("Record1", "Description 1");
        System.out.println("Created 'Record1' with ID " + id);
        id = client.addRecord("Record2", "Description 2");
        System.out.println("Created 'Record2' with ID " + id);
        id = client.addRecord("Record3", "Description 3");
        System.out.println("Created 'Record3' with ID " + id);

        Map<BigInteger, String> records = client.getRecords();
        System.out.println("Records: " + records);

        id = client.addLabel("Label 1");
        System.out.println("Created 'Label 1' with ID " + id);
        id = client.addLabel("Label 2");
        System.out.println("Created 'Label 2' with ID " + id);
        id = client.addLabel("Label 3");
        System.out.println("Created 'Label 3' with ID " + id);

        List<BigInteger> list = new ArrayList<>();
        list.add(BigInteger.valueOf(1));
        list.add(BigInteger.valueOf(3));
        client.addLabelsToRecord(BigInteger.valueOf(1), list);
    }

}