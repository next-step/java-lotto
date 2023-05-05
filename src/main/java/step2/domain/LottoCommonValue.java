package step2.domain;

public enum LottoCommonValue {

    MINIMUM_MATH_COUNT_INCLUSIVE(3),
    MAXIMUM_MATH_COUNT_EXCLUSIVE(7),
    DEFAULT_LOTTO_PRICE(1000),
    DEFAULT_LOTTO_NUMBER_COUNT(6);

    private int value;

    LottoCommonValue(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }





}
