package lotto.objects;

import java.util.ArrayList;
import java.util.List;

public class Counts {
    private List<Integer> counts;

    public Counts() {
        this.counts = new ArrayList<>();
    }
    public Counts(List<Integer> counts) {
        this.counts = counts;
    }

    public List<Integer> getCounts() {
        return counts;
    }

    public void updateCount(int index) {
        counts.set(index, counts.get(index) + 1);
    }
}
