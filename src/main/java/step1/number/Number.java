package step1.number;

import step1.exception.NegativeNumberInputException;

public final class Number {

    private final int number;
    private final int ZERO = 0;

    public Number(String number) {
        this(Integer.parseInt(number));
    }

    public Number(int number) {
        if(isNegative(number)) {
            throw new NegativeNumberInputException();
        }
        this.number = number;
    }

    private final boolean isNegative(int number) {
        return number < ZERO;
    }

    /*
    private int convertStringToInt(String number) {
        try {
            Integer.parseInt(number);
        } catch (Exception e) {
            throw new NegativeNumberInputException();
        }
    }
    */
}
