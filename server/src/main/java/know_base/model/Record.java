package know_base.model;

import java.math.BigInteger;
import java.util.List;

public class Record {
    private BigInteger id;
    private String title;
    private String text;
    private List<Label> labels;
    private List<File> files;

    public Record(BigInteger id, String title, String text, List<Label> labels, List<File> file) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.labels = labels;
        this.files = files;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }

    public void addLabels(List<Label> labels) {
        this.labels.addAll(labels);
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public void addFile(File file) {
        this.files.add(file);
    }
}
