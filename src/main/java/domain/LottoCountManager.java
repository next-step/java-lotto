package domain;

public class LottoCountManager {
    private int money;
    private int manualCount;

    public LottoCountManager(int money, int manualCount) {
        this.money = money;
        this.manualCount = manualCount;

        if (!isEnoughMoney(manualCount)) {
            throw new IllegalArgumentException("돈이 부족합니다. ATM 다녀오세요.");
        }
    }

    private boolean isEnoughMoney(int manualCount) {
        return getTotalCount() >= manualCount;
    }

    private int getTotalCount() {
        return money / Lotto.PRICE;
    }

    public int manualCount() {
        return manualCount;
    }

    public int autoCount() {
        return getTotalCount() - manualCount;
    }
}
