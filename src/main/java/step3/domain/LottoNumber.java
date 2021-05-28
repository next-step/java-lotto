package step3.domain;

import step3.exception.inValidLottoNumberException;


public class LottoNumber implements Comparable<LottoNumber> {

    public static final int BEG_LOTTO_NUM = 1;
    public static final int END_LOTTO_NUM = 45;
    private static LottoNumber[] CACHE = new LottoNumber[45 + 1];

    protected int number;

    protected LottoNumber() {

    }
    private LottoNumber(int number) {
        this.number = number;
    }

    private static void checkIfValidLotto(int number) {
        if (number < BEG_LOTTO_NUM || number > END_LOTTO_NUM) {
            throw new inValidLottoNumberException();
        }
    }


    @Override
    public int compareTo(LottoNumber lottoNumber) {
        return Integer.compare(number, lottoNumber.number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    public static LottoNumber valueOf(int number) {
        checkIfValidLotto(number);

        if(CACHE[number] != null) {
            return CACHE[number];
        }

        CACHE[number] = new LottoNumber(number);
        return CACHE[number];
    }
}
