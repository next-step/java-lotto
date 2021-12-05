package lotto.domain;


public class LottosBuyer {

    public static final int PRICE = 1000;

    private final int purchaseAmount;
    private final int manualLottoCount;

    public LottosBuyer(int purchaseAmount, int manualLottoCount) {
        checkPurchaseValidation(purchaseAmount / PRICE, manualLottoCount);
        this.purchaseAmount = purchaseAmount;
        this.manualLottoCount = manualLottoCount;
    }

    public Lottos buyRandomLottos() {
        Lottos randomLottos = Lottos.ofRandomLottos(this.purchaseAmount / PRICE - manualLottoCount);
        return randomLottos;
    }

    public Lottos getTotalLottos(Lottos randomLottos, Lottos manualLottos) {
        manualLottos.mergeLottos(randomLottos);
        Lottos totalLottos = Lottos.ofLottos(manualLottos.getLottos());
        return totalLottos;
    }

    private void checkPurchaseValidation(int allLottosCount, int manualLottoCount) {
        if (allLottosCount - manualLottoCount < 0) {
            throw new IllegalArgumentException("전체 로또 수 보다, 수동 로또를 많이 구매할 수 없습니다.");
        }
    }
}
