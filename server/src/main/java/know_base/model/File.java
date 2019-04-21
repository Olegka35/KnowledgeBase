package know_base.model;

import java.util.List;

public class File {
    private String name;
    private List<Short> bytes;

    public File(String name, List<Short> bytes) {
        this.name = name;
        this.bytes = bytes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Short> getBytes() {
        return bytes;
    }

    public void setBytes(List<Short> bytes) {
        this.bytes = bytes;
    }
}
