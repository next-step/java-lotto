package lotto.model;

import lotto.util.LottoNumberUtil;

public class LottoNumber implements Comparable<LottoNumber> {

    private int lottoNumber;

    public LottoNumber(int number) {
        LottoNumberUtil.validNumber(number);
        lottoNumber = number;
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

    @Override
    public int compareTo(LottoNumber number1) {
        return Integer.compare(this.getLottoNumber(), number1.getLottoNumber());
    }
}
