package calculator;

import java.util.Objects;
import java.util.Optional;

public class NumberElement {

    int value;

    public NumberElement(String value){
        String nullSafeValue = Optional.ofNullable(value).orElse("0");
        this.value = isEmpty(nullSafeValue) ? 0 : Integer.parseInt(nullSafeValue);
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

    private boolean isEmpty(String value){
        return value.trim().isEmpty();
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
