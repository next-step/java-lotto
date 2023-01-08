package lottoGame.domain;

public class Money {
    private final int money;
    private final int manualLottoCount;

    public Money(int money, int manualLottoCount) {
        if (manualLottoCount * 1000 > money) {
            throw new IllegalArgumentException("예산보다 많은 로또를 구매할 수 없습니다.");
        }
        this.money = money;
        this.manualLottoCount = manualLottoCount;
    }

    public int getAutoLottoCount() {
        return money / 1000 - manualLottoCount;
    }

    public int getManualLottoCount() {
        return manualLottoCount;
    }
}
