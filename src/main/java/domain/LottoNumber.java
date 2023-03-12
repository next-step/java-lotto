package domain;

import java.util.Comparator;

public class LottoNumber {
    private int number;

    public LottoNumber(int input) {
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
        if (input < 1)
            throw new IllegalArgumentException("Lotto 숫자는 1보다 커야 합니다.");

        if (input > 45)
            throw new IllegalArgumentException("Lotto 숫자는 45보다 작아야 합니다.");
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

}
