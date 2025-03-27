package step2.lotto.model;

import java.util.Objects;
import step2.lotto.exception.CountException;

public class Count {

    private long value;

    public Count(String value) {
        validate(value);
        this.value = Integer.parseInt(value);
    }

    public Count(long value) {
        validate(value);
        this.value = value;
    }

    public long value() {
        return value;
    }

    public void increase() {
        value++;
    }

    public void validate(long value) {
        if (value < 0) {
            throw new CountException();
        }
    }

    private void validate(String count) {
        try {
            Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new CountException();
        }
        validate(Integer.parseInt(count));
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Count)) return false;
        Count count1 = (Count) o;
        return value == count1.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

}
