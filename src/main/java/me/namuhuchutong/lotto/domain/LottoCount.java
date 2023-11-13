package me.namuhuchutong.lotto.domain;


import java.util.Objects;

public class LottoCount {

    private final long count;

    public LottoCount(long count) {
        validateCount(count);
        this.count = count;
    }

    private void validateCount(long count) {
        if (count < 0) {
            throw new IllegalArgumentException("로또 당첨 번호 수는 음수일 수 없습니다.");
        }
    }

    public Long getCount() {
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
        return Objects.hash(count);
    }

    @Override
    public String toString() {
        return count + "번 일치";
    }
}
