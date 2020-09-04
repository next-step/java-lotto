package lotto.domain;

import lotto.context.Error;

public class LottoNum implements Comparable<LottoNum> {
    public static final Integer MIN_LOTTO_NUM = 1;
    public static final Integer MAX_LOTTO_NUM = 45;

    private final int lottoNum;

    public LottoNum(Integer lottoNum) {
        validLottoNumNullCheck(lottoNum);
        validLottoNumNumberCheck(lottoNum);
        this.lottoNum = lottoNum;
    }

    private void validLottoNumNullCheck(Integer lottoNum) {
        if (lottoNum == null || "".equals(lottoNum)) {
            throw new IllegalArgumentException(Error.ERROR_INPUT_TYPE.getMsg());
        }
    }

    private void validLottoNumNumberCheck(Integer lottoNum) {
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

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public static LottoNum of(Integer num) {
        return new LottoNum(num);
    }

    public static LottoNum of(String num) {
        validStringToInteger(num);
        return of(Integer.parseInt(num));
    }

    private static void validStringToInteger(String num) {
        try {
            Integer.parseInt(num);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Error.ERROR_INPUT_NULL.getMsg());
        }
    }
}
