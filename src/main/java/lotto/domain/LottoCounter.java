package lotto.domain;

public class LottoCounter {

    public static final int LOTTO_PRICE = 1000;
    private final int manualLottoCount;
    private final int autoLottoCount;

    public LottoCounter(int money, int manualLottoCount) {
        int totalLottoCount = getLottoCount(money);

        this.manualLottoCount = manualLottoCount;
        this.autoLottoCount = totalLottoCount - manualLottoCount;
        if (this.autoLottoCount < 0) {
            throw new IllegalArgumentException("money and manual lotto count is wrong");
        }
    }

    public static int getLottoCount(int money) {
        return money / LOTTO_PRICE;
    }

    public int getManualLottoCount() {
        return manualLottoCount;
    }

    public int getAutoLottoCount() {
        return autoLottoCount;
    }
}
