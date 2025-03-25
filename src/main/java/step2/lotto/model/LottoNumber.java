package step2.lotto.model;

import step2.lotto.exception.LottoNumberException;

public class LottoNumber {

    private final int value;
    private final static int MIN_VALUE = 1;
    private final static int MAX_VALUE = 45;

    public LottoNumber(String value) {
        validate(value);
        this.value = Integer.parseInt(value);
    }

    public LottoNumber(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new LottoNumberException();
        }
    }

    private void validate(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new LottoNumberException();
        }
        validate(Integer.parseInt(value));
    }

    public int value() {
        return value;
    }

}
