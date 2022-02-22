package lotto.domain;

public class RandomLottoCount {

    private static final int NOT_PURCHASE_RANDOM_LOTTO = 0;
    private int count;

    public RandomLottoCount(final LottoCounts lottoCounts,final ManualCount manualCount) {
        this.count = lottoCounts.getLottoCounts() - manualCount.getManualCount();
    }

    public boolean possiblePurchaseRandomLotto(){
        return count>NOT_PURCHASE_RANDOM_LOTTO;
    }
    public int getCount() {
        return count;
    }
}
