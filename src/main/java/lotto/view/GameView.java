package lotto.view;

import lotto.domain.*;

public class GameView {
    InputView inputView = new InputView();
    ResultView resultView = new ResultView();

    public void start() {
        Money money = buyLottoTicket(); // 로또 티켓 구매
        LottoTickets userLottoTickets = generateLottoTickets(money); // 로또 티켓 생성
        LottoTicket winningLottoTicket = new LottoTicket(inputView.inputWinningNumber()); // 지난주 당첨 번호 입력
        showGameResult(winningLottoTicket, userLottoTickets, money); // 게임 결과 확인
        inputView.close();
    }

    private Money buyLottoTicket() {
        Money money = new Money(inputView.inputMoney());
        resultView.printLottoTicketCount(money.countLottoTicket()); // 로또 구매 개수 출력

        return money;
    }

    private LottoTickets generateLottoTickets(Money money) {
        LottoTickets lottoTickets = new LottoTickets(money.countLottoTicket());
        resultView.printLottoTickets(lottoTickets.getString()); // 로또 티켓 출력

        return lottoTickets;
    }

    private void showGameResult(LottoTicket winningLottoTicket, LottoTickets userLottoTickets, Money money) {
        int bonusNumber = inputView.inputBonusBall();
        GameResult gameResult = new GameResult(winningLottoTicket, userLottoTickets, bonusNumber);
        resultView.printGameResult(gameResult.getGameResult()); // 게임 결과 출력

        long prizeSum = userLottoTickets.getPrizeSum(winningLottoTicket, bonusNumber);
        resultView.printResultProfit(money.calculateProfit(prizeSum)); // 총 수익률 출력
    }

}
