package lotto.domain;

/**
 * @author han
 */
public class LottoNumber {
    private static final int BASE = 0;
    private static final int BOUND = 45;

    private final int number;

    public LottoNumber(int number) {
        validateNumber(number);
        this.number = number;
    }

    public LottoNumber(String input) {
        this(stringToInt(input));
    }

    public int getNumber() {
        return number;
    }

    private static int stringToInt(String input) {
        return Integer.parseInt(input);
    }

    private void validateNumber(int number) {
        if (number < BASE || number > BOUND) {
            throw new RuntimeException();
        }
    }
}
