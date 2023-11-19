package lotto.domain;

public class LottoNumber {
    private final Integer START_NUMBER = 1;
    private final Integer END_NUMBER = 45;
    private int number;

    public LottoNumber() {}

    public LottoNumber(int number) {
        if (number < START_NUMBER && START_NUMBER < number) {
            System.out.println(number);
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

    public Integer getStartNumber() {
        return START_NUMBER;
    }

    public Integer getEndNumber() {
        return END_NUMBER;
    }

    public int getLottoNumber() { return number; }
}
