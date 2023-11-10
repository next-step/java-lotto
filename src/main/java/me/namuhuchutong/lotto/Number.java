package me.namuhuchutong.lotto;


public class Number {

    private final Integer values;

    public Number(Integer values) {
        validateNumbersRange(values);
        this.values = values;
    }

    private void validateNumbersRange(Integer values) {
        if (1 > values || values > 45) {
            throw new IllegalArgumentException("숫자는 1~45 사이만 가능합니다");
        }
    }
}
