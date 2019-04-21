package know_base.repo;

import know_base.model.File;
import know_base.model.Label;
import know_base.model.Record;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DataRepository {
    private static int nextRecordID = 1;
    private static int nextLabelID = 1;
    private static Map<BigInteger, Record> records = new HashMap<>();
    private static Map<BigInteger, Label> labels = new HashMap<>();

    public BigInteger addRecord(String title, String text) {
        BigInteger id = BigInteger.valueOf(nextRecordID);
        records.put(id, new Record(id, title, text, new ArrayList<>(), null));
        nextRecordID ++;
        return id;
    }

    public void addLabels(BigInteger recordID, List<BigInteger> labelIDs) {
        List<Label> labelList = new ArrayList<>();
        for(BigInteger id: labelIDs) {
            labelList.add(labels.get(id));
        }
        Record record = records.get(recordID);
        record.addLabels(labelList);
    }

    public void addFile(BigInteger recordID, String fileName, List<Short> bytes) {
        Record record = records.get(recordID);
        record.addFile(new File(fileName, bytes));
    }

    public BigInteger addLabel(String text) {
        BigInteger id = BigInteger.valueOf(nextLabelID);
        labels.put(id, new Label(id, text));
        nextLabelID++;
        return id;
    }

    public List<Short> getFile(BigInteger recordID, String fileName) {
        Record record = records.get(recordID);
        for(File file: record.getFiles()) {
            if(file.getName().equals(fileName))
                return file.getBytes();
        }
        return null;
    }

    public void removeLabel(BigInteger labelID) {
        labels.remove(labelID);
    }

    public List<Label> getLabels() {
        return (List<Label>) labels.values();
    }

    public List<Record> getRecords() {
        return new ArrayList<>(records.values());
    }

    public List<Record> getRecords(String labelText) {
        List<Record> result = new ArrayList<>();
        Label foundLabel = null;
        for(Label label: labels.values()) {
            if(label.getText().equals(labelText)) {
                foundLabel = label;
                break;
            }
        }
        if(foundLabel == null)
            return null;
        for(Record record: records.values()) {
            if(record.getLabels().contains(foundLabel))
                result.add(record);
        }
        return result;
    }
}
