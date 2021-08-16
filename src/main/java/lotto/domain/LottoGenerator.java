package lotto.domain;

public class LottoGenerator {

    public static Lottos createAutoLottos(PurchaseAmount purchaseAmount) {
        Lottos lottos = new Lottos();
        lottos.create(purchaseAmount);
        return lottos;
    }
}
