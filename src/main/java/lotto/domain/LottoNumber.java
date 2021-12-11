package lotto.domain;

public class LottoNumber {
    public static final int MIN = 1;
    public static final int MAX = 45;
    private final int number;

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException("로또 번호는 1 ~ 45의 숫자만 가능합니다.");
        }
    }

}
