package lotto;

import java.util.List;

import lotto.domain.LottoResult;
import lotto.domain.LottoShop;
import lotto.domain.LottoTicket;
import lotto.domain.WinnerNumber;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class LottoApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        int money = inputView.purchaseAmount();
        LottoShop lottoShop = new LottoShop();
        List<LottoTicket> lottoTickets = lottoShop.buyLotto(money);
        resultView.printPurchaseCount(lottoTickets);

        WinnerNumber winnerNumber = new WinnerNumber(inputView.inputWinnerNumbers());
        int bonusNumber = inputView.inputBonusNumber();
        LottoResult lottoResult = new LottoResult();
        lottoResult.calculateRank(lottoTickets, winnerNumber, bonusNumber);
        resultView.printMatchResult(lottoResult.getResult());
        resultView.printRateResult(lottoResult.getRate(money));
    }
}
