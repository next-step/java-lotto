package lotto.view;

import lotto.domain.*;

public class GameView {
    InputView inputView = new InputView();
    ResultView resultView = new ResultView();

    public void start() {
        Money money = new Money(inputView.inputMoney());
        int lottoTicketCount = money.countLottoTicket();
        resultView.printLottoTicketCount(money.countLottoTicket()); // 로또 구매 개수 출력

        LottoTickets lottoTickets = new LottoTickets(lottoTicketCount);
        resultView.printLottoTickets(lottoTickets.printLottoTickets()); // 로또 티켓 출력

        LottoTicket winningLottoTicket = new LottoTicket(inputView.inputWinningNumber());
        new LottoGamePlayer().play(winningLottoTicket, lottoTickets); //게임 실행 (로또 매칭 확인)

        long prizeSum = lottoTickets.getPrizeSum(winningLottoTicket);
        resultView.printResultProfit(money.calculateProfit(prizeSum)); // 총 수익률 확인

        inputView.close();
    }
}
