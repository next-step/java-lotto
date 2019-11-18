import lotto.LottoController;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningRank;
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

        Lottos lottos = lottoController.execute(money, manualLottosNumbers);

        int[] winLotto = InputView.getWinLotto();
        int bonusNumber = InputView.getBonusNumber();
        WinningRank winningRank = lottoController.applyRank(winLotto, bonusNumber);
        lottoController.viewResult(lottos, winningRank, money);
    }
}