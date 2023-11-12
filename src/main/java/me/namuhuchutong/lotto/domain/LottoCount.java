package me.namuhuchutong.lotto.domain;


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
    public String toString() {
        return count + "번 일치";
    }
}
