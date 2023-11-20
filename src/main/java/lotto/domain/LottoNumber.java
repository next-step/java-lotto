package lotto.domain;

public class LottoNumber {
    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 45;
    private int number;

    public LottoNumber() {}

    public LottoNumber(int number) {
        if (number < START_NUMBER || END_NUMBER < number) {
            throw new IllegalArgumentException("Lotto number is more than 1 and less then 46");
        }
        this.number = number;
    }

    public void checkDuplicateNumber(LottoNumber other) {
        if (getResultIfEqual(other) == 1) {
            throw new IllegalArgumentException("Input duplicate lotto number");
        }
    }

    public int getResultIfEqual(LottoNumber other) {
        if (number == other.number) {
            return 1;
        }
        return 0;
    }

    public int getLottoNumber() { return number; }
}
