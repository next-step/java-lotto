package domain;

public class LottoAmount {

    private int amount;

    private LottoAmount(int amount) {
        this.amount = amount;
    }

    public static LottoAmount from(int amount){
        return new LottoAmount(amount);
    }

    public int getAmount() {
        return amount;
    }

    public static boolean isAmountPositive(LottoAmount amount) {
        return amount.getAmount() > 0;
    }
}
