package step2;

public class PositiveNumber {

    private final String text;

    public PositiveNumber(String text) {
        checkNegative(text);

        this.text = text;
    }

    private void checkNegative(String text) {
        if (Integer.parseInt(text) < 0) {
            throw new NegativeNumberException();
        }
    }

    public Integer intValue() {
        return Integer.parseInt(this.text);
    }

}
