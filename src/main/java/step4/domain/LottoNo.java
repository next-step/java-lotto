package step4.domain;

import java.util.Objects;

public class LottoNo implements Comparable<LottoNo> {

    private final int lottoNo;

    public LottoNo(int lottoNo) {
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
