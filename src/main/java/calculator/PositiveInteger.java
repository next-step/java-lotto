package calculator;

public class PositiveInteger {

    private int positiveNumber;

    public PositiveInteger(String item) {
        this.positiveNumber = toInt(item);
    }

    private int toInt(String item) {
        int number;

        try {
            number = Integer.parseInt(item);
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }

        if (number < 0) {
            throw new IllegalArgumentException();
        }

        return number;
    }

    public int getPositiveNumber() {
        return positiveNumber;
    }
}
