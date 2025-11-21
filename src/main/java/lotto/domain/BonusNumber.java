package lotto.domain;

import java.util.Objects;

public class BonusNumber {

    private final int value;

    public BonusNumber() {
        this(0);
    }

    public BonusNumber(int value) {
        this.value = value;
    }

    public NumberElement toNumberElement() {
        return new NumberElement(value);
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BonusNumber that = (BonusNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return "BonusNumber{" +
                "value=" + value +
                '}';
    }

}
