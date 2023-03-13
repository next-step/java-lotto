package domain;

import java.util.Objects;

public class LottoNumber {
    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 45;
    private int number;

    public LottoNumber(int input) {
        try {
            validate(input);
        } catch (Exception e) {
            throw e;
        }

        number = input;
    }

    public LottoNumber(String strInput) {
        int input = LottoUtil.stringToInt(strInput);
        try {
            validate(input);
        } catch (Exception e) {
            throw e;
        }

        number = input;
    }

    public int getNumber() {
        return number;
    }

    void validate(int input) {
        if (input < MIN_NUMBER)
            throw new IllegalArgumentException(String.format("Lotto 숫자는 %d보다 커야 합니다.", MIN_NUMBER));

        if (input > MAX_NUMBER)
            throw new IllegalArgumentException(String.format("Lotto 숫자는 %d보다 작아야 합니다.", MAX_NUMBER));
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public boolean equals(Object object) {
        LottoNumber lottoNumber = (LottoNumber) object;
        if (this.getNumber() == lottoNumber.getNumber()) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
