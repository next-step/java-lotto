package step3.domain;

import step3.exception.inValidLottoNumberException;


public class LottoNumber {

    public static final Integer BEG_LOTTO_NUM = 1;
    public static final Integer END_LOTTO_NUM = 45;

    private final int number;

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
    public String toString() {
        return String.valueOf(number);
    }

    public Integer valueOf() { return this.number; }
}
