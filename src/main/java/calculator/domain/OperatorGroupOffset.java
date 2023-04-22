package calculator.domain;

import java.util.Objects;

public class OperatorGroupOffset {
    private static final int INITIALIZE_NUMBER = -1;
    private static final int INCREASE_NUMBER = 1;
    private int offset;

    public OperatorGroupOffset(int offset) {
        this.offset = offset;
    }

    public static OperatorGroupOffset initialize() {
        return new OperatorGroupOffset(INITIALIZE_NUMBER);
    }

    public int increaseAndGet() {
        offset += INCREASE_NUMBER;
        return offset;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperatorGroupOffset that = (OperatorGroupOffset) o;
        return offset == that.offset;
    }

    @Override
    public int hashCode() {
        return Objects.hash(offset);
    }

}
