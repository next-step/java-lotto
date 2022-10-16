package step2.domain;

public interface LottoNumberRange {
    int MAX_LOTTO = 45;
    int MIN_LOTTO = 1;

    default void validateNumberRange(int lottNumber) {
        if (lottNumber > MAX_LOTTO || lottNumber < MIN_LOTTO) {
            throw new IllegalArgumentException("로또 번호는 1~45여야 합니다. 입력한 번호: " + lottNumber);
        }
    }
}
