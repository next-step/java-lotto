package domain;

import java.util.List;

import javax.annotation.processing.Generated;

public class ManualRequest {
    private int manualCount;
    private List<int[]> manualNumbers;

    public ManualRequest(int manualCount, List<int[]> manualNumbers) {
        this.manualCount = manualCount;
        this.manualNumbers = manualNumbers;
    }

    public int getManualCount() {
        return manualCount;
    }

    public List<int[]> getManualNumbers() {
        return manualNumbers;
    }
}
