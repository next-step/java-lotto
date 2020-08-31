package lotto.domain;

import lotto.context.Error;

public class LottoNum {
    public static final Integer MIN_LOTTO_NUM = 1;
    public static final Integer MAX_LOTTO_NUM = 45;

    private final int lottoNum;

    public LottoNum(Integer lottoNum) {
        vaildLottoNum(lottoNum);
        this.lottoNum = lottoNum;
    }

    private void vaildLottoNum(Integer lottoNum) {
        if (lottoNum < MIN_LOTTO_NUM || lottoNum > MAX_LOTTO_NUM) {
            throw new IllegalArgumentException(Error.ERROR_WINNING_NUMBER.getMsg());
        }
    }

    public int getLottoNum() {
        return lottoNum;
    }
}
