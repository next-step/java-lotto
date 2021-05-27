package step2.model;

import step2.exception.LottoOutOfBoundException;

public class LottoNumber implements Comparable<LottoNumber> {

    public final static int MIN = 1;
    public final static int MAX = 45;

    private final int LottoNumber;

    public LottoNumber(int lottoNumber) {
        validateNumbers(lottoNumber);
        this.LottoNumber = lottoNumber;
    }

    public int getNumber() {
        return LottoNumber;
    }

    static public LottoNumber of(int number) {
        return new LottoNumber(number);
    }

    public static void validateNumbers(int lottoNumber) {
        if (lottoNumber < MIN || lottoNumber > MAX) {
            throw new LottoOutOfBoundException();
        }
    }

    @Override
    public int compareTo(LottoNumber lottoNumber) {
        return LottoNumber - lottoNumber.LottoNumber;
    }
}
