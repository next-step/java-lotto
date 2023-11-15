package lotto;

import lotto.domain.LottoResult;
import lotto.domain.Money;
import lotto.domain.LottoMachine;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.domain.WinningRank;
import lotto.view.InputView;
import lotto.view.PrintView;

import java.util.Map;

public class LottoController {
    public static void main(String[] args) {
        long inputAmount = InputView.requestPurchaseAmount();
        Money userMoney = new Money(inputAmount);

        LottoMachine lottoMachine = new LottoMachine(userMoney);
        PrintView.printLottoTickets(lottoMachine.getLottoTickets());

        String winningNumbers = InputView.requestWinningNumber();
        int bonusNumber = InputView.requestBonusNumber();
        WinningLotto winningLotto = WinningLotto.createWinningNumbers(winningNumbers, bonusNumber);
        LottoResult lottoResult = new LottoResult(winningLotto, lottoMachine.getLottoTickets());

        Map<Rank, Long> winningRanks = lottoResult.findWinningRankCont();
        PrintView.printStatistics(winningRanks);

        Money totalWinningMoney = new WinningRank(winningRanks).calcTotalWinningPrice();
        PrintView.printReturnRate(totalWinningMoney.calcReturnRate(userMoney));
    }
}
