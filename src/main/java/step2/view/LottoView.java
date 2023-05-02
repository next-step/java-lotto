package step2.view;

import step2.domain.PurchasedLotto;

public class LottoView {

    private final PurchasedLotto purchasedLotto;

    public LottoView(PurchasedLotto purchasedLottoList) {
        this.purchasedLotto = purchasedLottoList;
    }

    public void printLotto() {
        purchasedLotto.get().forEach(lotto -> System.out.println(lotto.getDetailNumbers()));
        System.out.println();
    }
}
