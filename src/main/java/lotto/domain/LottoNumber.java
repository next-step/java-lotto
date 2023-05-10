package lotto.domain;

public class LottoNumber {

    private static final int START_NUMBER = 1;
    private static final int LIMIT_NUMBER = 46;
    private final int number;

    public LottoNumber(int number) {
        isLottoCandidateNumber(number);
        this.number = number;
    }

    private void isLottoCandidateNumber(int number) {
        if (!isBetweenStartNumberAndLimitNumber(number)) {
            throw new IllegalArgumentException("로또 번호는 1과 45 사이의 숫자여야만 합니다.");
        }
    }

    private static boolean isBetweenStartNumberAndLimitNumber(int number) {
        return START_NUMBER <= number && number < LIMIT_NUMBER;
    }

    public int getNumber() {
        return number;
    }
}
