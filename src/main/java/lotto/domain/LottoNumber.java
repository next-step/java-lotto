package lotto.domain;

public class LottoNumber {

    private final int number;
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number < MIN_VALUE || number > MAX_VALUE) {
            throw new IllegalArgumentException(String.format("Lotto 숫자 범위는 %s~%s 입니다.", MIN_VALUE, MAX_VALUE));
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) obj;
        return number == that.number;
    }
}
