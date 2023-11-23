package lotto.domain;

import java.util.Objects;

public class LottoNo implements Comparable<LottoNo> {

    public static final int LOTTO_MIN = 1;
    public static final int LOTTO_MAX = 45;
    private final int lottoNo;

    public LottoNo(int lottoNo) {
        if (lottoNo < LOTTO_MIN || lottoNo > LOTTO_MAX) {
            throw new IllegalArgumentException("1 ~ 45 사이 정수만 가능합니다.");
        }
        this.lottoNo = lottoNo;
    }

    @Override
    public int compareTo(LottoNo o) {
        return Integer.compare(lottoNo, o.lottoNo());
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

    int lottoNo() {
        return lottoNo;
    }
}