package lotto;

import java.util.List;

import lotto.domain.LottoShop;
import lotto.domain.LottoTickets;
import lotto.domain.WinnerNumber;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class LottoApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        int money = inputView.purchaseAmount();
        LottoShop lottoShop = new LottoShop();
        List<List<Integer>> manualNumber = inputView.inputManualNumber();
        LottoTickets lottoTickets = lottoShop.buyLotto(money, manualNumber);
        resultView.printPurchaseCount(lottoTickets);

        List<Integer> winnerNumbers = inputView.inputWinnerNumbers();
        int bonusNumber = inputView.inputBonusNumber();
        WinnerNumber winnerNumber = new WinnerNumber(winnerNumbers, bonusNumber);
        lottoTickets.calculate(winnerNumber);
        resultView.printMatchResult(lottoTickets.getResult());
        resultView.printRateResult(lottoTickets.getRate(money));
    }
}
