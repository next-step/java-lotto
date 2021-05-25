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
        resultView.printLottoTickets(lottoTickets.getString()); // 로또 티켓 출력

        LottoTicket winningLottoTicket = new LottoTicket(inputView.inputWinningNumber());
        int bonusNumber = inputView.inputBonusBall();
        new LottoGamePlayer().play(winningLottoTicket, lottoTickets, bonusNumber); //게임 실행 (로또 매칭 확인)

        long prizeSum = lottoTickets.getPrizeSum(winningLottoTicket, bonusNumber);
        resultView.printResultProfit(money.calculateProfit(prizeSum)); // 총 수익률 출력

        inputView.close();
    }
}
