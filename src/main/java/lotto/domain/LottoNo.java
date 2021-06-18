package lotto.domain;

import lotto.common.Constant;
import lotto.common.MessageCode;
import lotto.exceptions.NumberRangeException;

import java.util.Objects;

public class LottoNo {
    private int lottoNo;

    public LottoNo(int lottoNo) {
        validateLottoNo(lottoNo);
        this.lottoNo = lottoNo;
    }

    private void validateLottoNo(int lottoNo) {
        if (lottoNo > Constant.MAX_LOTTO_NUMBER.value() || lottoNo < Constant.MIN_LOTTO_NUMBER.value())
            throw new NumberRangeException();
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
