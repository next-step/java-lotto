package lotto.domain;


public class LottoNumber {

    private static int LOTTO_MAX_NUMBER = 45;
    private static int LOTTO_MIN_NUMBER = 1;

    private int number;

    public LottoNumber(int number) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException("LOTTO번호가 범위를 초과합니다.");
        }
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

}
