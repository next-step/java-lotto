package lotto.Model;

public class BonusNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final int number;

    public BonusNumber(String input) {
        int number;
        try {
            number = Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("보너스 번호는 숫자여야 합니다.");
        }

        if (containNotValidNumber(number)) {
            throw new IllegalArgumentException("로또 번호는 1부터 45까지의 숫자여야 합니다.");
        }

        this.number = number;
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
