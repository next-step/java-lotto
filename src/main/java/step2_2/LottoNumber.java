package step2_2;

public class LottoNumber {

    private static final int LOTTO_MIN = 1;
    private static final int LOTTO_MAX = 45;

    private int number;

    public LottoNumber(int number) {
        checkRange(number);
        this.number = number;
    }

    private void checkRange(int number) {
        if (number < LOTTO_MIN || number > LOTTO_MAX) {
            throw new InvalidLottoNumberException();
        }
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
