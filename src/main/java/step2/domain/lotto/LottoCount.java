package step2.domain.lotto;

public class LottoCount {
    private final int count;

    public LottoCount(int count) {
        this.count = count;
    }

    public int value() {
        return count;
    }

    public LottoCount add(LottoCount other) {
        return new LottoCount(this.count + other.value());
    }

    public LottoCount subtract(LottoCount other) {
        if (this.count < other.value()) {
            throw new IllegalArgumentException("빼려는 값이 원래 값보다 큽니다.");
        }
        return new LottoCount(this.count - other.value());
    }

    public boolean isBiggerThan(LottoCount other) {
        return this.count > other.value();
    }
}
