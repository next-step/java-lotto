package step2;

import step2.domain.Lotto;
import step2.domain.LottoTickets;
import step2.domain.WinningResults;
import step2.view.InputView;
import step2.view.ResultView;

public class Main {

    public static void main(String[] args) {

        int money = InputView.inputPurchasePrice();
        Lotto lotto = new Lotto(money);

        ResultView.announceTotalLottoTicketCount(lotto.getTotalLottoTicketCount());

        LottoTickets lottoTickets = lotto.getLottoTickets();
        ResultView.announceTotalLottoNumbers(lottoTickets);

        WinningResults winningResults = new WinningResults();
        String winningNumbersLastWeek = InputView.inputWinningNumbersLastWeek();
        winningResults.saveWinningLottoNumber(winningNumbersLastWeek);

        winningResults.checkWinning(lottoTickets);
        ResultView.resultStart();
        ResultView.WinningResult(winningResults);
    }
}
