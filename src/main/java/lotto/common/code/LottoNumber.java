package lotto.common.code;

public enum LottoNumber {

    MINIMUM_LOTTO_NUMBER (1),
    MAXIMUM_LOTTO_NUMBER (45);

    private final int number;

    LottoNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

}
