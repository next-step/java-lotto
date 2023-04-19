package domain;

import java.util.Objects;

public class OperatorGroupOffset {
    private static final int INITIALIZE_NUMBER = 0;
    private final int offset;

    public OperatorGroupOffset(int offset) {
        this.offset = offset;
    }

    public static OperatorGroupOffset initialize() {
        return new OperatorGroupOffset(INITIALIZE_NUMBER);
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
