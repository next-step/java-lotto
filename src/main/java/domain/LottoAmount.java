package domain;

public class LottoAmount {

    private int amount;

    public LottoAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public static boolean isAmountPositive(LottoAmount amount) {
        return amount.getAmount() > 0;
    }
}
