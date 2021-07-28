package lotto.domain;

public class LottoNumber extends Number {
    private final int value;

    public LottoNumber(int value) {
        this.value = value;
    }

    @Override
    public int intValue() {
        return 0;
    }

    @Override
    public long longValue() {
        return 0;
    }

    @Override
    public float floatValue() {
        return 0;
    }

    @Override
    public double doubleValue() {
        return 0;
    }
}
