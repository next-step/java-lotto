package domain;

import java.util.List;

import javax.annotation.processing.Generated;

public class ManualRequest {
    private int manualCount;
    private List<List<Integer>> manualNumbers;

    public ManualRequest(int manualCount, List<List<Integer>> manualNumbers) {
        this.manualCount = manualCount;
        this.manualNumbers = manualNumbers;
    }

    public int getManualCount() {
        return manualCount;
    }

    public List<List<Integer>> getManualNumbers() {
        return manualNumbers;
    }
}
