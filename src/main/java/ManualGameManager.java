import interaction.InputView;
import interaction.OutputView;
import lotto.dto.ManualGameDto;
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
        ManualGameDto manualGameDto = InputView.budgetAndManualCount();
        manualGameDto.isValidManualCountBy(lottoPrice());

        LottoStore store = new ManualLottoStore(manualGameDto, lottoPrice());
        OutputView.purchaseCountResult(store.purchaseCount());
        return store.produceLotto();
    }

}
