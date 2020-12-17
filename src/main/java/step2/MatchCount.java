package step2;

import java.util.Objects;

public class MatchCount {
    private static final int MIN = 0;
    private static final int MAX = 6;
    private long value;

    public MatchCount(long value) {
        if(value < MIN || value > MAX){
            throw new IllegalArgumentException("Invalid MatchCount valeu");
        }
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    public boolean isSame(int value){
        return this.value == value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchCount that = (MatchCount) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
