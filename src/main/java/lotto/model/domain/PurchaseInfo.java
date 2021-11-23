package lotto.model.domain;

public class PurchaseInfo {

    private final static int MIN_AMOUNT = 0;
    private final static int LOTTO_PRICE = 1000;
    private final int amount;

    public PurchaseInfo(int amount){
        checkValidation(amount);
        this.amount = amount;
    }

    public int getLotteryCount() {
        return this.amount / LOTTO_PRICE;
    }

    public int getAmount() {
        return this.amount;
    }

    private void checkValidation(int amount) {
        if(amount < MIN_AMOUNT) {
            throw new IllegalArgumentException("구매액은 음수일 수 없습니다.");
        }
    }
}