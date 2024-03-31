package lottery;

import lottery.domain.LottoTickets;
import lottery.domain.WinningLotto;
import lottery.service.LottoDrawer;
import lottery.view.InputView;
import lottery.view.ResultView;

public class LottoApplication {

    public static void main(String[] args){
        Integer moneyAmount = InputView.moneyAmount();
        LottoTickets lottoTickets = new LottoTickets(moneyAmount);
        ResultView.purchasedLottoTicketsResult(lottoTickets);

        String winningNumbersString = InputView.winningNumbersString();
        Integer bonusNumberInteger = InputView.bonusNumberInteger();
        WinningLotto winningLotto = new WinningLotto(winningNumbersString, bonusNumberInteger);

        LottoDrawer lottoDrawer = new LottoDrawer(lottoTickets, winningLotto);

        ResultView.winStatistics(lottoDrawer.winStatistics());
        ResultView.profitRate(lottoDrawer.profitRate());
    }
}
