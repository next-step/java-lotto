package stringaddcalculator.domain;

import java.util.Objects;

public class Number {

    private int number;

    public Number(String number) {
        ValidationNumber.invalidInput(number);
        this.number = toInt(number);
        ValidationNumber.negativeQuantity(this.number);
    }

    private static int toInt(String number) {
        int result = Integer.parseInt(number);
        return result;
    }

    public int is() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

}
