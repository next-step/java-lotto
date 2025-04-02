package lotto;

public class LottoNumber {
    private final int number;
    public static final int LOTTO_MIN = 1;
    public static final int LOTTO_MAX = 45;

    public LottoNumber(int number) {
        validateNumber(number);
        this.number = number;
    }

    private void validateNumber(int number) {
        if (number < LOTTO_MIN || number > LOTTO_MAX) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이여야 합니다.");
        }
    }

    public int getNumber() {
        return number;
    }
}
