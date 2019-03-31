package lotto.domain;

public class ManualLottery {
    private Lotteries manualLotteries;
    private int quantity;

    public ManualLottery(int quantity) {
        this.manualLotteries = new Lotteries();
        this.quantity = quantity;
    }

    public Lotteries generateManualLotteries(Lotteries manualLotteries) {
        return this.manualLotteries = manualLotteries;
    }

    public StringBuilder toStringManualLotteries() {
        return this.manualLotteries.toStringLotteries();
    }

    public int getManualLotteriesSize() {
        return this.manualLotteries.size();
    }
}
