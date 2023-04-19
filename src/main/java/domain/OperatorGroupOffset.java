package domain;

import java.util.Objects;

public class OperatorGroupOffset {
    private static final int INITIALIZE_NUMBER = 0;
    private static final int INCREASE_NUMBER = 1;
    private int offset;

    private OperatorGroupOffset(int offset) {
        this.offset = offset;
    }

    public static OperatorGroupOffset initialize() {
        return of(INITIALIZE_NUMBER);
    }

    public static OperatorGroupOffset of(int offset){
        return new OperatorGroupOffset(offset);
    }


    public OperatorGroupOffset increase() {
        this.offset += INCREASE_NUMBER;
        return this;
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
