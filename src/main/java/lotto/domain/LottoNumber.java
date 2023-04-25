package lotto.domain;

public class LottoNumber {

    private final int number;

    public LottoNumber(int number) {
        this.number = number;
    }

    public int value() {
        return number;
    }
}
