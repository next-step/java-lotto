package lottery.domain;

import lombok.ToString;

@ToString
public class Money {
    public static final int AVAILABLE_PURCHASE_VALUE = 0;
    public static final int ONE_GAME_MONEY = 1000;
    private int purchaseCount = 0;
    private int randomCount = 0;
    private int manualCount = 0;

    public Money(int inputMoney, int inputManualCount) {
        checkInputMoney(inputMoney);
        this.purchaseCount = inputMoney / ONE_GAME_MONEY;
        this.manualCount = inputManualCount;
        checkManualCount();
        this.randomCount = initRandomCount();
    }

    private void checkInputMoney(int inputMoney) {
        if(inputMoney < ONE_GAME_MONEY) {
            throw new IllegalArgumentException("돈은 천원부터!!");
        }
    }

    private void checkManualCount() {
        if(initRandomCount() < AVAILABLE_PURCHASE_VALUE) {
            throw new IllegalArgumentException("내신 돈보다 더 많은 걸 살 순 없어요!");
        }
    }

    private int initRandomCount() {
        return purchaseCount - manualCount;
    }

    public int randomCount() {
        return randomCount;
    }
    public int manualCount() {return this.manualCount; }
}
