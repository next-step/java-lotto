package lotto.view;

import lotto.common.ErrorCode;
import lotto.domain.*;

import java.util.List;

public class GameView {
    InputView inputView = new InputView();
    ResultView resultView = new ResultView();

    public void start() {
        Money money = new Money(inputView.inputMoney()); // 로또 티켓 구매
        int manualTicketCount = inputView.inputManualTicketCount(); // 수동 로또 티켓 개수
        LottoTickets userLottoTickets = generateLottoTicket(manualTicketCount, money); // 로또 티켓 생성
        LottoTicket winningLottoTicket = new LottoTicket(inputView.inputWinningNumber()); // 지난주 당첨 티켓 입력
        showGameResult(winningLottoTicket, userLottoTickets, money); // 게임 결과 출력
        inputView.close();
    }

    private LottoTickets generateLottoTicket(int manualTicketCount, Money money) {
        int autoTicketCount = money.countAutoLottoTicket(manualTicketCount); // 자동 로또 티켓 개수
        if (manualTicketCount + autoTicketCount > money.countLottoTicket()) {
            throw new IllegalArgumentException(ErrorCode.INVALID_TICKET_COUNT_RANGE.getErrorMessage());
        }
        List<LottoTicket> manualLottoTickets = generateManualLottoTickets(manualTicketCount); // 수동 로또 티켓 생성
        LottoTickets autoLottoTickets = generateAutoLottoTickets(autoTicketCount); // 자동 로또 티켓 생성
        resultView.printLottoTicketCount(manualTicketCount, autoTicketCount); //로또 티켓 구매 개수 출력
        LottoTickets userLottoTickets = autoLottoTickets.addAll(manualLottoTickets); // 수동, 자동 티켓 병합
        resultView.printLottoTickets(userLottoTickets.getString()); // 병합된 로또 티켓 출력

        return userLottoTickets;
    }

    private List<LottoTicket> generateManualLottoTickets(int ticketCount) {
        return inputView.inputManualLottoTicket(ticketCount);
    }

    private LottoTickets generateAutoLottoTickets(int ticketCount) {
        return new LottoTickets(ticketCount);
    }

    private void showGameResult(LottoTicket winningLottoTicket, LottoTickets userLottoTickets, Money money) {
        int bonusNumber = inputView.inputBonusBall();
        GameResult gameResult = new GameResult(winningLottoTicket, userLottoTickets, bonusNumber);
        resultView.printGameResult(gameResult.getGameResult()); // 게임 결과 출력

        long prizeSum = userLottoTickets.getPrizeSum(winningLottoTicket, bonusNumber);
        resultView.printResultProfit(money.calculateProfit(prizeSum)); // 총 수익률 출력
    }

}
