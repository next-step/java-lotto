package lotto.domain;

import lotto.exception.LottoRangeException;

import java.util.Objects;

public class LottoNo implements Comparable<LottoNo> {

    public static final int MIN = 1;
    public static final int MAX = 45;

    private final int lottoNo;

    LottoNo(int lottoNo) {
        validate(lottoNo);
        this.lottoNo = lottoNo;
    }

    private static boolean checkLottoNoRange(int lottoNo) {
        return lottoNo <= MAX
                && lottoNo >= MIN;
    }

    static void validate(int lottoNo) {
        if (!checkLottoNoRange(lottoNo)) {
            throw LottoRangeException.getInstance();
        }
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
