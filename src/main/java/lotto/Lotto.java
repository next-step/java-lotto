package lotto;

import java.util.Arrays;

public class Lotto {
    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;
    private static final String INVALID_LOTTO_NUMBERS_MESSAGE = "적절한 로또 입력이 아닙니다.";

    private final int[] lottoNumbers;

    public Lotto(int[] lottoNumbers) {
        if (!isValidLottoNumbers(lottoNumbers)) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBERS_MESSAGE);
        }

        this.lottoNumbers = Arrays.stream(lottoNumbers)
                .sorted()
                .toArray();
    }

    public int[] getLottoNumbers() {
        return lottoNumbers;
    }

    private boolean isValidLottoNumbers(int[] lottoNumbers) {
        if (lottoNumbers.length != LOTTO_NUMBER_SIZE) {
            return false;
        }

        if (!isBetweenMinAndMax(lottoNumbers)) {
            return false;
        }

        if (!hasUniqueNumbers(lottoNumbers)) {
            return false;
        }

        return true;
    }

    private boolean isBetweenMinAndMax(int[] lottoNumbers) {
        return Arrays.stream(lottoNumbers)
                .noneMatch(it ->
                        it < MINIMUM_LOTTO_NUMBER ||
                                it > MAXIMUM_LOTTO_NUMBER
                );
    }

    private boolean hasUniqueNumbers(int[] lottoNumbers) {
        return Arrays.stream(lottoNumbers)
                .distinct()
                .count() == LOTTO_NUMBER_SIZE;
    }
}
