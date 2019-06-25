package calculator;

import java.util.Objects;

public class NumberElement {

    int value;

    public NumberElement(String value){
        this.value = Integer.parseInt(value);
    }

    public NumberElement(int value) {
        this.value = value;
    }

    public NumberElement() {
        this(0);
    }

    public NumberElement add(NumberElement element) {
        return new NumberElement(value + element.value);
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
