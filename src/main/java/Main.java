import lotto.LottoController;
import lotto.domain.Money;
import lotto.view.InputView;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        LottoController lottoController = new LottoController();

        int purchaseAmount = InputView.purchaseAmount();
        Money money = new Money(purchaseAmount);

        int manualCount = InputView.purchaseManualCount();
        List<String> manualLottosNumbers = InputView.inputManualLottoNumbers(manualCount);
        money.purchased(manualCount);

        lottoController.execute(money, manualLottosNumbers);
    }
}