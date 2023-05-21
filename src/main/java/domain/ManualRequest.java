package domain;

import java.util.List;
import java.util.Set;

import javax.annotation.processing.Generated;

public class ManualRequest {
    private int manualCount;
    private List<Set<Integer>> manualNumbers;

    public ManualRequest(int manualCount, List<Set<Integer>> manualNumbers) {
        this.manualCount = manualCount;
        this.manualNumbers = manualNumbers;
    }

    public int getManualCount() {
        return manualCount;
    }

    public List<Set<Integer>> getManualNumbers() {
        return manualNumbers;
    }
}
