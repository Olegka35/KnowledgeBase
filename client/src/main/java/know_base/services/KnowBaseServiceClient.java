package know_base.services;

import know_base.config.WebSvcClientConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class KnowBaseServiceClient {

    private WebServiceTemplate webServiceTemplate;

    public KnowBaseServiceClient() {
        this.webServiceTemplate = new WebSvcClientConfig().webServiceTemplate();
    }

    public BigInteger addRecord(String title, String text) {

        ObjectFactory factory = new ObjectFactory();

        AddRecordRequest req = factory.createAddRecordRequest();

        req.setTitle(title);
        req.setText(text);

        AddRecordResponse resp = (AddRecordResponse) webServiceTemplate.marshalSendAndReceive(req);

        return resp.getId();
    }

    public void addLabelsToRecord(BigInteger recordID, List<BigInteger> labelIDs) {

        ObjectFactory factory = new ObjectFactory();

        AddLabelsRequest req = factory.createAddLabelsRequest();

        req.setRecordID(recordID);
        ArrayOfId arrayOfId = new ArrayOfId();
        arrayOfId.getId().addAll(labelIDs);
        req.setLabels(arrayOfId);

        webServiceTemplate.marshalSendAndReceive(req);
    }

    public void addFileToRecord(BigInteger recordID, String fileName, List<Short> bytes) {

        ObjectFactory factory = new ObjectFactory();

        AddFileRequest req = factory.createAddFileRequest();

        req.setRecordID(recordID);
        req.setFileName(fileName);
        req.getText().addAll(bytes);

        webServiceTemplate.marshalSendAndReceive(req);
    }

    public List<Short> getFile(BigInteger recordID, String fileName) {

        ObjectFactory factory = new ObjectFactory();

        GetFileRequest req = factory.createGetFileRequest();
        req.setRecordID(recordID);
        req.setFileName(fileName);

        GetFileResponse response = (GetFileResponse)webServiceTemplate.marshalSendAndReceive(req);
        return response.text;
    }

    public BigInteger addLabel(String text) {

        ObjectFactory factory = new ObjectFactory();

        AddLabelRequest req = factory.createAddLabelRequest();

        req.setLabel(text);

        AddLabelResponse resp = (AddLabelResponse) webServiceTemplate.marshalSendAndReceive(req);
        return resp.getId();
    }

    public Map<BigInteger, String> getRecords() {
        Map<BigInteger, String> recordsMap = new HashMap<>();

        ObjectFactory factory = new ObjectFactory();

        GetRecordsRequest req = factory.createGetRecordsRequest();

        GetRecordsResponse resp = (GetRecordsResponse) webServiceTemplate.marshalSendAndReceive(req);
        List<Record> records = resp.getRecords();
        for(Record record: records) {
            recordsMap.put(record.id, record.title);
        }
        return recordsMap;
    }

    public Map<BigInteger, String> getRecordsByLabel(String label) {
        Map<BigInteger, String> recordsMap = new HashMap<>();

        ObjectFactory factory = new ObjectFactory();

        GetRecordsByLabelRequest req = factory.createGetRecordsByLabelRequest();

        GetRecordsResponse resp = (GetRecordsResponse) webServiceTemplate.marshalSendAndReceive(req);
        List<Record> records = resp.getRecords();
        for(Record record: records) {
            recordsMap.put(record.id, record.title);
        }
        return recordsMap;
    }

}
