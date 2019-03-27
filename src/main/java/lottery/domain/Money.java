package lottery.domain;

public class Money {
    public static final int ONE_GAME_MONEY = 1000;
    private int purchaseCount;

    public Money(int inputMoney) {
        if(inputMoney < ONE_GAME_MONEY) {
            throw new IllegalArgumentException("돈은 천원부터!!");
        }
        this.purchaseCount = inputMoney / ONE_GAME_MONEY;
    }

    public int purchaseCount() {
        return purchaseCount;
    }
}
