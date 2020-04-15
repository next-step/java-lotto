package lotto.vo;

public class LottoResultCount {

    private static final int INIT_COUNT = 0;
    private static final int INCREASE_COUNT_UNIT = 1;

    private final int count;

    public LottoResultCount() {
        this.count = INIT_COUNT;
    }

    public LottoResultCount(int count) {
        this.count = count;
    }

    public int increase() {
        return count + INCREASE_COUNT_UNIT;
    }

    public int getCount() {
        return count;
    }

    public int getPrize(final int perPrize) {
        return count * perPrize;
    }

    @Override
    public boolean equals(Object obj) {
        return this.count == ((LottoResultCount) obj).count;
    }
}
