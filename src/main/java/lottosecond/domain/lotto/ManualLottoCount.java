package lottosecond.domain.lotto;

import lottosecond.domain.LottoBuyMoney;

public class ManualLottoCount {

    private final int manualLottoCount;

    private ManualLottoCount(int manualLottoCount) {
        if (manualLottoCount < 0) {
            throw new IllegalArgumentException("수동 로또 개수가 0보다 작을 수 없습니다.");
        }
        this.manualLottoCount = manualLottoCount;
    }

    public static ManualLottoCount from(int manualLottoCount, LottoBuyMoney lottoBuyMoney) {
        int totalLottoCount = lottoBuyMoney.countLotto();
        if (manualLottoCount > totalLottoCount) {
            throw new IllegalArgumentException("수동 로또 개수가 총 구매 로또 수보다 클 수 없습니다.");
        }

        return new ManualLottoCount(manualLottoCount);
    }

    public int getManualLottoCount() {
        return manualLottoCount;
    }
}
