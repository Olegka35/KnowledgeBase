package know_base.model;

import java.math.BigInteger;

public class Label {
    private BigInteger id;
    private String text;

    public Label(BigInteger id, String text) {
        this.id = id;
        this.text = text;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
