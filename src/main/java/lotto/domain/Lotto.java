package lotto.domain;

public class Lotto {

    private static final int LOTTO_FIRST_NUMBER = 1;
    private static final int LOTTO_LAST_NUMBER = 45;
    private static final int LOTTO_NUMBERS_SIZE = 6;

    private final Numbers numbers;

    public Lotto() {
        numbers = new Numbers(LOTTO_FIRST_NUMBER, LOTTO_LAST_NUMBER, LOTTO_NUMBERS_SIZE);
        validateSize();
        validateDuplication();
    }

    private void validateSize() {
        if (numbers.getSize() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 넘버는 6개여야 합니다.");
        }
    }

    private void validateDuplication() {
        if (numbers.hasDuplication()) {
            throw new IllegalArgumentException("[ERROR] 로또 넘버에 중복이 있습니다.");
        }
    }

    public Numbers getNumbers() {
        return numbers;
    }
}
