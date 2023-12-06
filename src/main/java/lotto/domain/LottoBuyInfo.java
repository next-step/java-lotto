package lotto.domain;

public class LottoBuyInfo {

    private final int money;

    private final int manualCount;

    private final int autoCount;

    public LottoBuyInfo(int money, int manualCount) {
        if (money < Lotto.PRICE) {
            throw new IllegalArgumentException("유효하지 않은 값입니다.");
        }
        this.money = money;
        this.manualCount = manualCount;
        this.autoCount = (money / Lotto.PRICE) - manualCount;
    }

    public int getMoney() {
        return money;
    }

    public int getManualCount() {
        return manualCount;
    }

    public int getAutoCount() {
        return autoCount;
    }
}
