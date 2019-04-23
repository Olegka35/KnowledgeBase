package know_base.controller.methods;

import java.math.BigInteger;
import java.util.List;

public class LabelsIDs {
    private List<BigInteger> labelIDs;

    public List<BigInteger> getLabelIDs() {
        return labelIDs;
    }

    public void setLabelIDs(List<BigInteger> labelIDs) {
        this.labelIDs = labelIDs;
    }

    public LabelsIDs(List<BigInteger> labelIDs) {
        this.labelIDs = labelIDs;
    }
}
