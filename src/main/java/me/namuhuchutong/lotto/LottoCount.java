package me.namuhuchutong.lotto;


public class LottoCount {

    private final long count;

    public LottoCount(long count) {
        validateCount(count);
        this.count = count;
    }

    private void validateCount(long count) {
        if (3 > count || 6 < count) {
            throw new IllegalArgumentException("일치하는 로또는 3,4,5,6만 존재합니다.");
        }
    }

    public Long getCount() {
        return count;
    }

    @Override
    public String toString() {
        return count + "번 일치";
    }
}
