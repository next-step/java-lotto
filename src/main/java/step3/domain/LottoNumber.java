package step3.domain;

import step3.exception.inValidLottoNumberException;


public class LottoNumber implements Comparable<LottoNumber> {

    public static final Integer BEG_LOTTO_NUM = 1;
    public static final Integer END_LOTTO_NUM = 45;

    protected int number;

    public LottoNumber() {
    }

    public LottoNumber(int number) {
        checkIfValidLotto(number);

        this.number = number;
    }

    private void checkIfValidLotto(int number) {
        if (number < BEG_LOTTO_NUM || number > END_LOTTO_NUM) {
            throw new inValidLottoNumberException();
        }
    }


    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(this.valueOf(), o.valueOf());
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    public int valueOf() {
        return this.number;
    }
}
