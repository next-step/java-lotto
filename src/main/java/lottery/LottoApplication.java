package lottery;

import lottery.domain.LottoTickets;
import lottery.domain.Money;
import lottery.domain.WinningLotto;
import lottery.domain.factory.LottoTicketsDispenser;
import lottery.service.LottoDrawer;
import lottery.view.InputView;
import lottery.view.ResultView;

import java.util.List;

public class LottoApplication {

    public static void main(String[] args){
        Integer moneyAmount = InputView.moneyAmount();
        Money money = new Money(moneyAmount);

        Long manualLottoCount = InputView.manualLottoCount();
        List<String> manualNumbersStrings = InputView.manualNumbersStrings(manualLottoCount);

        LottoTickets lottoTickets = LottoTicketsDispenser.dispense(money, manualNumbersStrings);

        ResultView.purchasedLottoTicketsResult(lottoTickets);

        String winningNumbersString = InputView.winningNumbersString();
        Integer bonusNumberInteger = InputView.bonusNumberInteger();
        WinningLotto winningLotto = new WinningLotto(winningNumbersString, bonusNumberInteger);

        LottoDrawer lottoDrawer = new LottoDrawer(lottoTickets, winningLotto);

        ResultView.winStatistics(lottoDrawer.winStatistics());
        ResultView.profitRate(lottoDrawer.profitRate());
    }
}
