package lotto.domain;

public class LotteryMachine {

    private final int purchasePrice;

    public LotteryMachine(String purchasePrice) {
        this(Integer.parseInt(purchasePrice));
    }

    public LotteryMachine(int purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        LotteryMachine that = (LotteryMachine) o;

        return purchasePrice == that.purchasePrice;
    }

    @Override
    public int hashCode() {
        return purchasePrice;
    }
}
