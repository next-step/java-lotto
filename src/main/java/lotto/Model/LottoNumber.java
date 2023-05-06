package lotto.Model;

public class LottoNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private static int number;

    public LottoNumber(int input) {
        if (containNotValidNumber(input)) {
            throw new IllegalArgumentException("로또 번호는 1부터 45까지의 숫자여야 합니다.");
        }

        number = input;
    }

    private boolean containNotValidNumber(int input) {
        if (input < MIN_NUMBER) {
            return true;
        }

        return input > MAX_NUMBER;
    }

    public int number() {
        return number;
    }
}
