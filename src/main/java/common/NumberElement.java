package common;

import java.util.Objects;

public class NumberElement implements Comparable<NumberElement>{

    int value;

    public NumberElement(String value){
        this(isEmpty(value) ? 0 : Integer.parseInt(value.trim()));
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


    @Override
    public int compareTo(NumberElement element) {
        if(element == null){
            return 1;
        }

        if(this.value == element.value){
            return 0;
        }

        return this.value > element.value ? 1 : -1;
    }

    private static boolean isEmpty(String value){
        return value == null || value.trim().isEmpty();
    }
}
