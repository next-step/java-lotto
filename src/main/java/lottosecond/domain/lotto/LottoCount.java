package lottosecond.domain.lotto;

import lottosecond.domain.LottoBuyMoney;

public class LottoCount {

    private final LottoBuyMoney lottoBuyMoney;
    private final ManualLottoCount manualLottoCount;

    public LottoCount(int money, int manualLottoCount) {
        this.lottoBuyMoney = new LottoBuyMoney(money);
        this.manualLottoCount = ManualLottoCount.from(manualLottoCount, lottoBuyMoney);
    }

    public int totalLottoCount() {
        return lottoBuyMoney.countLotto();
    }

    public int manualLottoCount() {
        return manualLottoCount.getManualLottoCount();
    }

    public int autoLottoCount() {
        return lottoBuyMoney.countLotto() - manualLottoCount();
    }

    public ManualLottoCount getManualLottoCount() {
        return manualLottoCount;
    }
}
