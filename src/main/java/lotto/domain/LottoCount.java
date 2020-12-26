package lotto.domain;

public class LottoCount {
    public static final int LOTTO_COUNT_MIN = 1;
    private final int count;

    public LottoCount(int count) {
        if (count < LOTTO_COUNT_MIN) {
            throw new IllegalArgumentException("로또 갯수는 0보다 커야 합니다.");
        }
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LottoCount that = (LottoCount) o;

        return count == that.count;
    }

    @Override
    public int hashCode() {
        return count;
    }
}
