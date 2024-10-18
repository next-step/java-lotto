package lotto.domain.purchase;

public class PassivityLottoCount {
    private static final String PASSIVITY_ERROR_MESSAGE = "수동 로또 구매 %d개가 구매 가능한 로또 %d개를 초과했습니다.";
    private final int passivityLottoCount;

    public PassivityLottoCount(int passivityLottoCount) {
        this.passivityLottoCount = passivityLottoCount;
    }

    public static int isValidate(Money money, int passivityLottoCount) {
        int allMountLottoCounts = money.purchaseLottoCount();
        if (allMountLottoCounts < passivityLottoCount) {
            throw new IllegalArgumentException(String.format(PASSIVITY_ERROR_MESSAGE, passivityLottoCount, allMountLottoCounts));
        }
        return passivityLottoCount;
    }

    public int autoLottoCount(int purchaseLottoCount) {
        return purchaseLottoCount - passivityLottoCount;
    }

    public int getPassivityLottoCount() {
        return passivityLottoCount;
    }
}
