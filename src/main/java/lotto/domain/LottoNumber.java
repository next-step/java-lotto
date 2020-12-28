package lotto.domain;

public class LottoNumber {

    private final int number;

    public LottoNumber(int number) {
        if (number < Lotto.LOTTO_MIN_NUMBER || number > Lotto.LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException("로또 범위가 초과하였습니다.");
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
