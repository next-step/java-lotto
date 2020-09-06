package lotto.domain;

import lotto.context.Error;

public class LottoNum implements Comparable<LottoNum> {
    public static final Integer MIN_LOTTO_NUM = 1;
    public static final Integer MAX_LOTTO_NUM = 45;
    private static final Integer PRIME = 31;

    private final int lottoNum;

    private LottoNum(Integer lottoNum) {
        validLottoNumNullCheck(lottoNum);
        validLottoNumNumberCheck(lottoNum);
        this.lottoNum = lottoNum;
    }

    public static LottoNum of(Integer num) {
        return new LottoNum(num);
    }

    public static LottoNum of(String num) {
        return of(getValidStringToInteger(num));
    }

    private static void validLottoNumNullCheck(Integer lottoNum) {
        if (lottoNum == null || "".equals(lottoNum)) {
            throw new IllegalArgumentException(Error.ERROR_INPUT_TYPE.getMsg());
        }
    }

    private static void validLottoNumNumberCheck(Integer lottoNum) {
        if (lottoNum < MIN_LOTTO_NUM || lottoNum > MAX_LOTTO_NUM) {
            throw new IllegalArgumentException(Error.ERROR_WINNING_NUMBER.getMsg());
        }
    }

    private static Integer getValidStringToInteger(String num) {
        int conv;
        try {
            conv = Integer.parseInt(num);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Error.ERROR_INPUT_NULL.getMsg());
        }
        return conv;
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
        if (!(obj instanceof LottoNum)) {
            return false;
        }
        LottoNum lottoNum = (LottoNum) obj;
        return lottoNum.lottoNum == this.lottoNum;
    }

    @Override
    public int hashCode() {
        return PRIME + lottoNum;
    }
}
