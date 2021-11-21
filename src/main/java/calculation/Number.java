package calculation;

public class Number {
    private static final String NEGATIVE_NUMBER_ERROR_MESSAGE = "error : 음수는 사용할수 없습니다.";
    private static final int NEGATIVE_NUMBER_ZERO = 0;
    private final int number;

    public Number(String number) {
        this(Integer.parseInt(number));
    }

    public Number(int number) {
        checkNegativeNumber(number);
        this.number = number;
    }

    private void checkNegativeNumber(int number) {
        if (number < NEGATIVE_NUMBER_ZERO) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_ERROR_MESSAGE);
        }
    }

    public int value() {
        return number;
    }
}
