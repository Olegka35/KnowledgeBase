package know_base.endpoint;

import know_base.model.Record;
import know_base.repo.DataRepository;
import know_base.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.math.BigInteger;
import java.util.List;

@Endpoint
public class KnowledgeBaseEndpoint {
    private static final String NAMESPACE_URI = "http://know_base/services";

    @Autowired
    private DataRepository dataRepository;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addRecordRequest")
    @ResponsePayload
    public AddRecordResponse addRecord(@RequestPayload AddRecordRequest request) {
        AddRecordResponse addRecordResponse = new AddRecordResponse();
        BigInteger id = dataRepository.addRecord(request.getTitle(), request.getText());
        addRecordResponse.setId(id);
        return addRecordResponse;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addLabelsRequest")
    @ResponsePayload
    public Response addLabels(@RequestPayload AddLabelsRequest request) {
        Response response = new Response();
        dataRepository.addLabels(request.getRecordID(), request.getLabels().getId());
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addFileRequest")
    @ResponsePayload
    public Response addFile(@RequestPayload AddFileRequest request) {
        Response response = new Response();
        dataRepository.addFile(request.getRecordID(), request.getFileName(), request.getText());
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getFileRequest")
    @ResponsePayload
    public GetFileResponse getFile(@RequestPayload GetFileRequest request) {
        GetFileResponse response = new GetFileResponse();
        List<Short> bytes = dataRepository.getFile(request.getRecordID(), request.getFileName());
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addLabelRequest")
    @ResponsePayload
    public AddLabelResponse addLabel(@RequestPayload AddLabelRequest request) {
        AddLabelResponse addLabelResponse = new AddLabelResponse();
        BigInteger id = dataRepository.addLabel(request.getLabel());
        addLabelResponse.setId(id);
        return addLabelResponse;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getLabelsRequest")
    @ResponsePayload
    public GetLabelsResponse getLabels() {
        GetLabelsResponse response = new GetLabelsResponse();
        List<know_base.model.Label> labels = dataRepository.getLabels();
        for(know_base.model.Label label: labels) {
            Label temp = new Label();
            temp.setId(label.getId());
            temp.setText(label.getText());
            response.getLabel().add(temp);
        }
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "removeLabelRequest")
    @ResponsePayload
    public Response removeLabel(@RequestPayload RemoveLabelRequest request) {
        Response response = new Response();
        dataRepository.removeLabel(request.getLabelID());
        return response;
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getRecordsRequest")
    @ResponsePayload
    public GetRecordsResponse getRecords(@RequestPayload GetRecordsRequest request) {
        GetRecordsResponse records = new GetRecordsResponse();
        List<Record> recordList = dataRepository.getRecords();
        for(Record record: recordList) {
            know_base.services.Record record1 = new know_base.services.Record();
            record1.setId(record.getId());
            record1.setTitle(record.getTitle());
            records.getRecords().add(record1);
        }
        return records;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getRecordsByLabel")
    @ResponsePayload
    public GetRecordsResponse getRecordsByLabelRequest(@RequestPayload GetRecordsByLabelRequest request) {
        GetRecordsResponse records = new GetRecordsResponse();
        List<Record> recordList = dataRepository.getRecords(request.getLabel());
        for(Record record: recordList) {
            know_base.services.Record record1 = new know_base.services.Record();
            record1.setId(record.getId());
            record1.setTitle(record.getTitle());
            records.getRecords().add(record1);
        }
        return records;
    }
}
