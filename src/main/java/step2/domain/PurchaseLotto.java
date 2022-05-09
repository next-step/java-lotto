package step2.domain;

import java.util.List;

public class PurchaseLotto {
    private static final int LOTTO_PRICE = 1000;
    private int money;
    private int autoCount;
    private int manualCount;
    private List<String> manualPick;

    public PurchaseLotto(int money) {
        this.money = money;
    }

    public void update(List<String> manualPick) {
        this.autoCount = money / LOTTO_PRICE - manualCount;
        this.manualCount = manualPick.size();
        this.manualPick = manualPick;
    }

    public int getAutoCount() {
        return autoCount;
    }

    public int getManualCount() {
        return manualCount;
    }

    public List<String> getManualPick() {
        return manualPick;
    }

    public int getMoney() {
        return money;
    }
}
