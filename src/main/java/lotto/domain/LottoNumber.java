package lotto.domain;

public class LottoNumber {

    private final int number;
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private void validate(int number) {
        if (number < MIN_VALUE || number > MAX_VALUE) {
            throw new IllegalArgumentException("Lotto 숫자 범위는 1~45 입니다.");
        }
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
