package step3.lotto.model;

import step3.lotto.exception.LottoNumberException;

public class LottoNumber implements Comparable<LottoNumber> {

    public final static int MIN_VALUE = 1;
    public final static int MAX_VALUE = 45;
    private final int value;

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

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof LottoNumber) {
            return value == ((LottoNumber) obj).value;
        }
        return false;
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(value, o.value);
    }

}
