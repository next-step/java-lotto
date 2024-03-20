package autoLotto.model;

import java.util.Arrays;

public class Lotto {
    private int[] lotto;

    private static final int START_LOTTO_NUMBER = 1;
    private static final int END_LOTTO_NUMBER = 45;
    private static final int VALID_LOTTO_LENGTH = 6;

    private static final String INVALID_LOTTO_NUMBERS = "로또 번호의 개수는 6개이며, 각 번호는 1 이상 45 이하의 값만 가능합니다.";

    public Lotto(int[] lotto) {
        if (!isValidLottoNumbers(lotto)) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBERS);
        }
        this.lotto = lotto;
    }

    private boolean isValidLottoNumbers(int[] winNumbers) {
        if (winNumbers.length != VALID_LOTTO_LENGTH) {
            return false;
        }

        Arrays.sort(winNumbers);
        return isNumberInValidRange(winNumbers[0]) && isNumberInValidRange(winNumbers[VALID_LOTTO_LENGTH - 1]);
    }

    private boolean isNumberInValidRange(int number) {
        return number >= START_LOTTO_NUMBER && number <= END_LOTTO_NUMBER;
    }


    public String toString() {
        return Arrays.toString(lotto);
    }

    public int[] getLotto() { return lotto; }
}
