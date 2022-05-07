package study.step2;

import study.step2.domain.LottoGame;
import study.step2.domain.LottoAnalysis;
import study.step2.domain.LottoTickets;
import study.step2.domain.LottoWinningNumber;
import study.step2.view.InputView;
import study.step2.view.ResultView;


public class Application {
    public static void main(String[] args) {
        int purchasePrice = InputView.getLottoPurchasePrice();
        LottoGame lottoGame = new LottoGame(ResultView.printTicketCount(purchasePrice));
        LottoTickets tickets = lottoGame.getTickets();
        ResultView.printLottoTickets(tickets);

        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(InputView.getLottoWinningNumber());
        LottoAnalysis lottoAnalysis = new LottoAnalysis(tickets.getTickets(), lottoWinningNumber);
        ResultView.printLottoRanksInfos(tickets.getTickets(), lottoWinningNumber);
        ResultView.printLottoAnalysis(lottoAnalysis);
    }
}
