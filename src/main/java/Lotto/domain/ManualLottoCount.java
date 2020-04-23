package Lotto.domain;

public class ManualLottoCount {
    private static final int MINIMUM_LOTTO_COUNT = 0;
    private final int count;

    private ManualLottoCount(final int count, final int maxCount) {
        validateManualLotto(count, maxCount);
        this.count = count;
    }

    public static ManualLottoCount of(final int count, final int maxCount) {
        return new ManualLottoCount(count, maxCount);
    }

    public int getCount() {
        return count;
    }

    private void validateManualLotto(final int count, final int maxCount) {
        if (count < MINIMUM_LOTTO_COUNT || count > maxCount) {
            throw new IllegalArgumentException("Count of manual Lotto Should be more than " + MINIMUM_LOTTO_COUNT
                    + " and less than " + maxCount);
        }
    }
}
