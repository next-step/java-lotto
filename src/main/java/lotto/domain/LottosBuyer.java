package lotto.domain;


import static lotto.domain.Lotto.PRICE;
import static lotto.domain.Lotto.SIZE;


public class LottosBuyer {

    private final int purchaseAmount;
    private final int manualLottoCount;

    private LottosBuyer(int purchaseAmount, int manualLottoCount) {
        checkPurchaseValidation(purchaseAmount / PRICE, manualLottoCount);
        this.purchaseAmount = purchaseAmount;
        this.manualLottoCount = manualLottoCount;
    }

    public static LottosBuyer of(int purchaseAmount, int manualLottoCount) {
        return new LottosBuyer(purchaseAmount, manualLottoCount);
    }

    public static void checkPurchaseValidation(int allLottosCount, int manualLottoCount) {
        if (allLottosCount - manualLottoCount < 0) {
            throw new IllegalArgumentException("전체 로또 수 보다, 수동 로또를 많이 구매할 수 없습니다.");
        }
    }

    public Lottos buyRandomLottos() {
        return Lottos.ofRandomLottos(this.purchaseAmount / SIZE - manualLottoCount);
    }

}
