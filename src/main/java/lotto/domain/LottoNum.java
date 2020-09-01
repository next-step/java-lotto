package lotto.domain;

import lotto.context.Error;

import java.util.Comparator;

public class LottoNum implements Comparable<LottoNum> {
    public static final Integer MIN_LOTTO_NUM = 1;
    public static final Integer MAX_LOTTO_NUM = 45;

    private final int lottoNum;

    public LottoNum(Integer lottoNum) {
        validLottoNum(lottoNum);
        this.lottoNum = lottoNum;
    }

    private void validLottoNum(Integer lottoNum) {
        if (lottoNum < MIN_LOTTO_NUM || lottoNum > MAX_LOTTO_NUM) {
            throw new IllegalArgumentException(Error.ERROR_WINNING_NUMBER.getMsg());
        }
    }

    public int getLottoNum() {
        return lottoNum;
    }

    @Override
    public int compareTo(LottoNum o) {
        return o.getLottoNum() < getLottoNum() ? 1 : -1;
    }
}
