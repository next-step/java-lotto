package lotto.domain;

public class LottoNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final String INVALID_NUMBER = "숫자는 1 ~ 45 까지의 숫자만 가능합니다. 현재 숫자 : %d";

    private int number;

    public LottoNumber(int number) {
        if (number > MAX_NUMBER || number < MIN_NUMBER) {
            throw new IllegalArgumentException(String.format(INVALID_NUMBER, number));
        }

        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
