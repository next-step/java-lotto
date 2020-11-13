package lotto.domain;

import lotto.utils.validator.LottoNoValidator;

import java.util.Objects;

public class LottoNo implements Comparable<LottoNo> {

    private final int lottoNo;

    /**
     * NOTE: domain 바깥에서 LottoNo 객체가 생성되기를 원치 않으므로,
     * LottoNo 의 생성자를 전부 protected 로 한다.
     */
    protected LottoNo(int lottoNo) {
        LottoNoValidator.validateLottoNo(lottoNo);
        this.lottoNo = lottoNo;
    }

    @Override
    public String toString() {
        return Integer.toString(lottoNo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNo lottoNo1 = (LottoNo) o;
        return Objects.equals(lottoNo, lottoNo1.lottoNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNo);
    }

    @Override
    public int compareTo(LottoNo lottoNo) {
        return this.lottoNo - lottoNo.lottoNo;
    }
}
