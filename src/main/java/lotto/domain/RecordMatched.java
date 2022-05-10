package lotto.domain;

import java.util.Arrays;

public class RecordMatched {
    private final int[] recordMatched;

    public RecordMatched(int size) {
        this.recordMatched = new int[size];
    }

    public RecordMatched(int[] recordMatched) {
        this.recordMatched = recordMatched;
    }

    public int[] recordMatched() {
        return recordMatched;
    }

    public RecordMatched addByMatchedIndex(int index) {
        this.recordMatched[index]++;
        return new RecordMatched(this.recordMatched);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RecordMatched that = (RecordMatched) o;

        return Arrays.equals(recordMatched, that.recordMatched);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(recordMatched);
    }
}
