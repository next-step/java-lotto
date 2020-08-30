package lotto.domain;

import lotto.context.Error;

public class LottoNum {
    public static final Integer MIN_LOTTO_NUM = 1;
    public static final Integer MAX_LOTTO_NUM = 45;

    private int lottoNum;

    public LottoNum(Integer lottoNum) {
        vaild(lottoNum);
        this.lottoNum = lottoNum;
    }

    public int getLottoNum() {
        return lottoNum;
    }

    private void vaild(Integer lottoNum) {
        if (lottoNum < MIN_LOTTO_NUM || lottoNum > MAX_LOTTO_NUM) {
            throw new IllegalArgumentException(Error.ERROR_WINNING_NUMBER.getMsg());
        }
    }
}
