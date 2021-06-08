package lotto.domain;

import lotto.common.MessageCode;

import java.util.Objects;

public class LottoNo {
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MIN_LOTTO_NUMBER = 1;
    private int lottoNo;

    public LottoNo(int lottoNo) {
        validateLottoNo(lottoNo);
        this.lottoNo = lottoNo;
    }

    private void validateLottoNo(int lottoNo) {
        if (lottoNo > MAX_LOTTO_NUMBER || lottoNo < MIN_LOTTO_NUMBER)
            throw new IllegalArgumentException(MessageCode.INVALID_LOTTO_NUMBER_RANGE.message());
    }

    public int lottNo() {
        return lottoNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNo lottoNo1 = (LottoNo) o;
        return lottoNo == lottoNo1.lottoNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNo);
    }
}
