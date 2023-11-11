package lotto;

import lotto.domain.LottoResult;
import lotto.domain.Money;
import lotto.domain.LottoMachine;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.PrintView;

import java.util.List;

public class LottoController {
    public static void main(String[] args) {
        int inputAmount = InputView.requestPurchaseAmount();
        Money userMoney = new Money(inputAmount);

        LottoMachine lottoMachine = new LottoMachine(userMoney);
        PrintView.printLottoTickets(lottoMachine.getLottoTickets());

        String winningNumbers = InputView.requestWinningNumber();
        WinningLotto winningLotto = WinningLotto.createWinningNumbers(winningNumbers);
        LottoResult lottoResult = new LottoResult(winningLotto, lottoMachine.getLottoTickets());

        List<Rank> winningRanks = lottoResult.findWinningRanks();
        PrintView.printStatistics(winningRanks);

        Money totalWinningMoney = lottoResult.calcTotalWinningPrice(winningRanks);
        PrintView.printReturnRate(totalWinningMoney.calcReturnRate(userMoney));
    }
}
