package step1;

import java.util.Objects;

public class Index {

    private static final int START_INDEX_VALUE = 0;

    private int value;

    public Index(int value) {
        this.value = value;
    }

    public static Index ofStart() {
        return new Index(START_INDEX_VALUE);
    }

    public int getFirstOperandIndex() {
        if (this.value != START_INDEX_VALUE) {
            throw new IllegalStateException("연산이 시작할 때만 호출이 가능합니다.");
        }
        increaseValue();
        return START_INDEX_VALUE;
    }

    private void increaseValue() {
        this.value += 1;
    }

    public int getNextOperatorIndex() {
        if (this.value % 2 != 1) {
            throw new IllegalStateException("Operator 를 호출 가능한 인덱스 상태가 아닙니다.");
        }
        int result = this.value;
        increaseValue();
        return result;
    }

    public int getNextOperandIndex() {
        if (this.value == START_INDEX_VALUE || this.value % 2 != 0) {
            throw new IllegalStateException("Operand 를 호출 가능한 인덱스 상태가 아닙니다.");
        }
        int result = this.value;
        increaseValue();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Index index = (Index) o;
        return value == index.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
