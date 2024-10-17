package lotto.domain;

public class LottoAgent {
    private PurchasedLottos purchasedLottos;
    private Budget budget;

    private LottoAgent(Budget budget) {
        purchasedLottos = PurchasedLottos.newInstance();
        this.budget = budget;
    }

    public static LottoAgent newInstance() {
        return new LottoAgent(Budget.valueOf(0));
    }

    public void deposit(int price) {
        budget = budget.deposit(price);
    }

    public int buyAutomatically(LottoNumberSelectionStrategy selectionStrategy) {
        int buyingCount = budget.getAmount() / Lotto.LOTTO_PRICE;
        for (int i = 0; i < buyingCount; i++) {
            LottoNumbers automaticallySelected = selectionStrategy.select();
            buyLotto(automaticallySelected);
        }
        return buyingCount;
    }

    public void buyManually(LottoNumbers manuallySelected) {
        buyLotto(manuallySelected);
    }

    private void buyLotto(LottoNumbers numbers) {
        purchasedLottos = purchasedLottos.add(Lotto.of(purchasedLottos.generateNextId(), numbers));
        budget = budget.use(Lotto.LOTTO_PRICE);
    }

    public PurchasedLottos getPurchasedLottos() {
        return purchasedLottos;
    }
}
