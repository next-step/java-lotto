package lotto.domain;


import lotto.validator.LottosBuyerValidator;

import static lotto.domain.Lotto.PRICE;


public class LottosBuyer {

    private final int purchaseAmount;
    private final int manualLottoCount;
    private Lottos lottos;

    private LottosBuyer(int purchaseAmount, int manualLottoCount) {
        LottosBuyerValidator.checkPurchaseValidation(purchaseAmount / PRICE, manualLottoCount);
        this.purchaseAmount = purchaseAmount;
        this.manualLottoCount = manualLottoCount;
    }

    public static LottosBuyer of(int purchaseAmount, int manualLottoCount) {
        return new LottosBuyer(purchaseAmount, manualLottoCount);
    }

    public Lottos buyRandomLottos() {
        Lottos randomLottos = Lottos.ofRandomLottos(this.purchaseAmount / PRICE - manualLottoCount);
        this.lottos.mergeLottos(randomLottos);
        return randomLottos;
    }

    public Lottos buyManualLottos(Lottos lottos) {
        this.lottos = lottos;
        return lottos;
    }

    public Lottos getLottos() {
        return lottos;
    }
}
