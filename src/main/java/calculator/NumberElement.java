package calculator;

import java.util.Objects;
import java.util.Optional;

public class NumberElement {

    private static boolean isEmpty(String value){
        return value == null || value.trim().isEmpty();
    }

    int value;

    public NumberElement(String value){
        this(isEmpty(value) ? 0 : Integer.parseInt(value));
    }

    public NumberElement(int value) {

        if(value < 0){
            throw new IllegalArgumentException("음수는 입력 할 수 없습니다.");
        }

        this.value = value;
    }

    public NumberElement() {
        this(0);
    }

    public NumberElement add(NumberElement element) {
        return new NumberElement(value + element.value);
    }

    public boolean isZero() {
        return value == 0;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumberElement that = (NumberElement) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
