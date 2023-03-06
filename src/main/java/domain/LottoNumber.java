package domain;

public class LottoNumber {
    int number;

    public LottoNumber(Integer input) {
        try {
            validate(input);
        } catch (Exception e) {
            throw e;
        }

        number = input;
    }

    public int getLottoNumber() {
        return number;
    }

    void validate(Integer input) {
        if (input < 1)
            throw new IllegalArgumentException("Lotto 숫자는 1보다 커야 합니다.");

        if (input > 45)
            throw new IllegalArgumentException("Lotto 숫자는 45보다 작아야 합니다.");
    }

}
