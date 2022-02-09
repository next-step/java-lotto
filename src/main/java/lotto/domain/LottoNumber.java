package lotto.domain;

public class LottoNumber {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private final int number;

    public LottoNumber(int number) {
        validateNumberRange(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private void validateNumberRange(int number) {
        if (number > MAX_NUMBER | number < MIN_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 1에서 45까지의 숫자만 사용가능합니다.");
        }
    }

}
