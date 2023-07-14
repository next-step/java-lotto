package lotto.model;

public final class LottoCount {

    public static final int MIN_LOTTO_COUNT = 0;

    private final int count;

    public LottoCount(final int count) {
        validate(count);
        this.count = count;
    }

    private void validate(int count) {
        if (count < MIN_LOTTO_COUNT) {
            throw new IllegalArgumentException("로또의 개수는 " + MIN_LOTTO_COUNT + " 이상입니다.");
        }
    }

    public int getCount() {
        return count;
    }
}
