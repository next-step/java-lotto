package calculator;

import static calculator.util.IntParser.parseInt;

public class Number {

    private int number;

    public Number(final String number) {
        this.number = parseInt(number);
    }

    public void plus(final String number) {
        this.number += parseInt(number);
    }

    public void minus(final String number) {
        this.number -= parseInt(number);
    }

    public void multiplication(final String number) {
        this.number *= parseInt(number);
    }

    public void division(final String number) {
        this.number /= parseInt(number);
    }

    public int getIntValue() {
        return number;
    }
}
