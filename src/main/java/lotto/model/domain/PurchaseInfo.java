package lotto.model.domain;

public class PurchaseInfo {

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
        if(amount < LOTTO_PRICE) {
            throw new IllegalArgumentException("로또를 구매하지 않았습니다.");
        }
    }
}