package lotto.domain;


public class LottoAgent {
    private PurchasedLottos purchasedLottos;

    private LottoAgent() {
        purchasedLottos = PurchasedLottos.newInstance();
    }

    public static LottoAgent newInstance() {
        return new LottoAgent();
    }

    public void buy(int price, LottoNumberSelectionStrategy selectionStrategy) {
        int buyingCount = price / Lotto.LOTTO_PRICE;
        for (int i = 0; i < buyingCount; i++) {
            buyLotto(i, selectionStrategy);
        }
    }

    private void buyLotto(int id, LottoNumberSelectionStrategy selectionStrategy) {
        purchasedLottos = purchasedLottos.add(Lotto.of(id, selectionStrategy));
    }

    public PurchasedLottos getPurchasedLottos() {
        return purchasedLottos;
    }
}
