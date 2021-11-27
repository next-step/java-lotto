package lotto.model.domain;

public class PurchaseInfo {

    private final static int LOTTO_PRICE = 1000;
    private final static int MIN_COUNT = 0;
    private final int amount;
    private final int manualCount;

    public PurchaseInfo(int amount, int manualCount) {
        checkAmountValidation(amount);
        this.amount = amount;
        checkCountValidation(manualCount);
        this.manualCount = manualCount;
    }

    public int getManualCount() {
        return this.manualCount;
    }

    public int getAutoCount() {
        return getLotteryCount() - manualCount;
    }

    public int getLotteryCount() {
        return this.amount / LOTTO_PRICE;
    }

    public int getAmount() {
        return this.amount;
    }

    private void checkAmountValidation(int amount) {
        if(amount < LOTTO_PRICE) {
            throw new IllegalArgumentException("로또를 구매하지 않았습니다.");
        }
    }

    private void checkCountValidation(int count) {
        if(count < MIN_COUNT) {
            throw new IllegalArgumentException("0보다 큰 숫자를 입력하셔야 합니다.");
        }
        if(getLotteryCount() < count) {
            throw new IllegalArgumentException("수동으로 구매할 수 있는 로또 수를 넘었습니다.");
        }
    }
}