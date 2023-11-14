package lotto.domain;

public class ManualCount {

    private final int count;

    public ManualCount(int count,
                       BuyingAmount buyingAmount) {
        if (isMoreThenAmount(count, buyingAmount)) {
            throw new IllegalArgumentException();
        }
        this.count = count;
    }

    private static boolean isMoreThenAmount(int count,
                                            BuyingAmount buyingAmount) {
        return buyingAmount.isMoreThenAmount(count);
    }

    public int count() {
        return this.count;
    }

    public int difference(int countTotal) {
        return Math.abs(countTotal - this.count);
    }
}
