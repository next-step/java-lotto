package lotto.number;

public enum LottoNumberLimit {
    MAX(45),
    MIN(1);
    private final int limit;

    LottoNumberLimit(int number) {
        this.limit = number;
    }

    public int getValue() {
        return limit;
    }

    public boolean isUnder(int lottoNumber) {
        return limit < lottoNumber;
    }

    public boolean isAbove(int lottoNumber) {
        return limit > lottoNumber;
    }
}