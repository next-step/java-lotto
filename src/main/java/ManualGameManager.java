import interaction.InputView;
import interaction.OutputView;
import lotto.store.Budget;
import lotto.store.LottoStore;
import lotto.store.ManualLottoStore;
import lotto.store.Ticket;

public class ManualGameManager extends BonusLottoGameManager {

    protected ManualGameManager() {
        super();
    }

    public static void main(String[] args) {
        ManualGameManager manager = new ManualGameManager();
        manager.start();
    }

    @Override
    protected Ticket purchaseLotto() {
        Budget budget = InputView.budgetLottoPrice();
        int manualCount = InputView.manualLottoCount();
        LottoStore store = new ManualLottoStore(budget, LOTTO_PRICE_PER, manualCount);
        OutputView.purchaseCountResult(store.purchaseCount());
        return store.produceLotto();
    }

}
