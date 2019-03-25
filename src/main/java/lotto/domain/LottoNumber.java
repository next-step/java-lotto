package lotto.domain;

public class LottoNumber {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private final int number;

    public LottoNumber(int number) {
        if(number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException();
        }
        this.number = number;
    }

    private int getNumber() {
        return number;
    }

    public int compareNumber(LottoNumber lottoNumber) {
        if(number == lottoNumber.getNumber()) {
            return 1;
        }
        return 0;
    }

    public String printLottoNumber() {
        return String.valueOf(number);
    }
}
