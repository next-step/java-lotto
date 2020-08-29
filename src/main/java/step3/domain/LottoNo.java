package step3.domain;

import java.util.Objects;

public class LottoNo implements Comparable<LottoNo> {

    private final int lottoNo;

    public LottoNo(int lottoNo) {
        if (lottoNo < LottoConfig.FIRST_LOTTO_NUMBER || lottoNo > LottoConfig.LAST_LOTTO_NUMBER) {
            throw new IllegalArgumentException("1 ~ 45 사이의 값만 가능합니다.");
        }
        this.lottoNo = lottoNo;
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

    @Override
    public int compareTo(LottoNo other) {
        return this.lottoNo - other.lottoNo;
    }

    @Override
    public String toString() {
        return ((Integer) lottoNo).toString();
    }

}
