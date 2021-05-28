package lotto.view;

import lotto.common.ErrorCode;
import lotto.domain.*;

import java.util.List;

public class GameView {
    InputView inputView = new InputView();
    ResultView resultView = new ResultView();

    public void start() {
        Money money = pay(); // 로또 티켓 구매
        int manualTicketCount = inputManualLottoTicketCount(money); // 수동 로또 티켓 개수
        LottoTickets userLottoTickets = generateLottoTicket(manualTicketCount, money); // 로또 티켓 생성
        LottoTicket winningLottoTicket = inputWinningLottoTicket(); // 지난주 당첨 티켓 입력
        LottoNumber bonusNumber = inputBonusNumber(winningLottoTicket); //보너스 볼 입력

        GameResult gameResult = new GameResult(winningLottoTicket, userLottoTickets, bonusNumber);
        resultView.printGameResult(gameResult.getGameResult()); // 게임 결과 출력
        long prizeSum = userLottoTickets.getPrizeSum(winningLottoTicket, bonusNumber);
        resultView.printResultProfit(money.calculateProfit(prizeSum)); // 총 수익률 출력
    }

    private Money pay() {
        try {
            return new Money(inputView.inputMoney());
        } catch (NumberFormatException nfe) {
            System.out.println(ErrorCode.INPUT_MISS_MATCHED.getErrorMessage());
            return pay();
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            return pay();
        }
    }

    private int inputManualLottoTicketCount(Money money) {
        try {
            int manualTicketCount = inputView.inputManualTicketCount();
            money.countAutoLottoTicket(manualTicketCount);
            return manualTicketCount;
        } catch (NumberFormatException nfe) {
            System.out.println(ErrorCode.INPUT_MISS_MATCHED.getErrorMessage());
            return inputManualLottoTicketCount(money);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            return inputManualLottoTicketCount(money);
        }
    }

    private LottoTickets generateLottoTicket(int manualTicketCount, Money money) {
        int autoTicketCount = money.countAutoLottoTicket(manualTicketCount); // 자동 로또 티켓 개수
        List<LottoTicket> manualLottoTickets = generateManualLottoTicket(manualTicketCount); // 수동 로또 티켓 생성
        LottoTickets autoLottoTickets = generateAutoLottoTickets(autoTicketCount);// 자동 로또 티켓 생성
        resultView.printLottoTicketCount(manualTicketCount, autoTicketCount); //로또 티켓 구매 개수 출력
        LottoTickets userLottoTickets = autoLottoTickets.addAll(manualLottoTickets); // 수동, 자동 티켓 병합
        resultView.printLottoTickets(userLottoTickets.getString()); // 병합된 로또 티켓 출력

        return userLottoTickets;
    }

    private List<LottoTicket> generateManualLottoTicket(int ticketCount) {
        try {
            return inputView.inputManualLottoTicket(ticketCount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return generateManualLottoTicket(ticketCount);
        }
    }

    private LottoTickets generateAutoLottoTickets(int ticketCount) {
        try {
            return new LottoTickets(ticketCount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return generateAutoLottoTickets(ticketCount);
        }
    }

    private LottoTicket inputWinningLottoTicket() {
        try {
            return new LottoTicket(inputView.inputWinningNumber());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinningLottoTicket();
        }
    }

    private LottoNumber inputBonusNumber(LottoTicket winningLottoTicket) {
        try {
            LottoNumber bonusNumber = new LottoNumber(inputView.inputBonusBall());
            throwDuplicatedBonusBallException(winningLottoTicket, bonusNumber);
            return bonusNumber;
        } catch (NumberFormatException nfe) {
            System.out.println(ErrorCode.INPUT_MISS_MATCHED.getErrorMessage());
            return inputBonusNumber(winningLottoTicket);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            return inputBonusNumber(winningLottoTicket);
        }
    }

    private void throwDuplicatedBonusBallException(LottoTicket winningLottoTicket, LottoNumber bonusNumber) {
        if (winningLottoTicket.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorCode.DUPLICATED_BONUS_NUMBER.getErrorMessage());
        }
    }

}
