package domain;

import java.util.Objects;

public class OperandGroupOffset {
    private static final int INITIALIZE_NUMBER = -1;
    private static final int INCREASE_NUMBER = 1;
    private int offset;

    public OperandGroupOffset(int offset) {
        this.offset = offset;
    }

    public static OperandGroupOffset initialize() {
        return new OperandGroupOffset(INITIALIZE_NUMBER);
    }

    public int increaseAndGet() {
        offset += INCREASE_NUMBER;
        return offset;
    }

    public boolean isLastOffset(int operandGroupSize) {
        return offset < operandGroupSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperandGroupOffset that = (OperandGroupOffset) o;
        return offset == that.offset;
    }

    @Override
    public int hashCode() {
        return Objects.hash(offset);
    }

}
