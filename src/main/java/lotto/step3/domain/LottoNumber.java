package lotto.step3.domain;

public class LottoNumber {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private int lottoNumber;

    public LottoNumber(int number) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException("로또 숫자는 " + LOTTO_MIN_NUMBER + "~" + LOTTO_MAX_NUMBER + "만 가능합니다.");
        }
        lottoNumber = number;
    }
}
