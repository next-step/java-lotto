package lotto.domain;

import java.util.Objects;

public class LottoMatchCount {

    private final int count;
    private final static int LOTTOCOUNT_MINIMUM = 0;
    private final static int LOTTOCOUNT_MAXIMUM = 6;
    private static String LOTTOCOUNT_BOUND_EXCEPTION = "LottoCount는 %d이상 %d이하여야 합니다.";

    public LottoMatchCount(final int count) {
        if (checkCount(count)) {
            throw new IllegalArgumentException(LOTTOCOUNT_BOUND_EXCEPTION);
        }
        this.count = count;
    }

    private boolean checkCount(final int count) {
        return count < LOTTOCOUNT_MINIMUM || count > LOTTOCOUNT_MAXIMUM;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoMatchCount that = (LottoMatchCount) o;
        return count == that.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }
}
