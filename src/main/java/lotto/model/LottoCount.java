package lotto.model;

public final class LottoCount {

    private final int count;

    public LottoCount(final int count) {
        validate(count);
        this.count = count;
    }

    private void validate(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("로또의 개수는 0 이상입니다.");
        }
    }

    public int getCount() {
        return count;
    }
}
