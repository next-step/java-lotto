package lotto.view;

import lotto.common.ErrorCode;
import lotto.domain.*;

import java.util.ArrayList;
import java.util.List;

public class GameView {
    InputView inputView = new InputView();
    ResultView resultView = new ResultView();

    public void start() {
        Money money = pay(); // 로또 티켓 구매
        int manualTicketCount = inputManualLottoTicketCount(money); // 수동 로또 티켓 개수
        List<LottoTicket> lottoTickets = generateLottoTicket(manualTicketCount, money); // 로또 티켓 생성
        LottoTicket winningTicket = inputWinningLottoTicket(); // 지난주 당첨 티켓 입력
        WinningLottoTicket winningLottoTicket = generateWinningLottoTicket(winningTicket);

        GameResult gameResult = new GameResult(winningLottoTicket, lottoTickets);
        resultView.printGameResult(gameResult.getGameResult()); // 게임 결과 출력
        long prizeSum = winningLottoTicket.getPrizeSum(lottoTickets);
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

    private List<LottoTicket> generateLottoTicket(int manualTicketCount, Money money) {
        int autoTicketCount = money.countAutoLottoTicket(manualTicketCount); // 자동 로또 티켓 개수
        List<LottoTicket> lottoTickets = generateManualLottoTicket(manualTicketCount); // 수동 로또 티켓 생성
        lottoTickets.addAll(generateAutoLottoTickets(autoTicketCount));// 자동 로또 티켓 생성 및 병합
        resultView.printLottoTicketCount(manualTicketCount, autoTicketCount); //로또 티켓 구매 개수 출력
        resultView.printLottoTickets(lottoTickets); // 병합된 로또 티켓 출력

        return lottoTickets;
    }

    private List<LottoTicket> generateManualLottoTicket(int ticketCount) {
        try {
            List<String> lottoTicketTexts = inputView.inputManualLottoTicket(ticketCount);
            List<LottoTicket> lottoTickets = new ArrayList<>();
            for (String lottoTicketText : lottoTicketTexts) {
                lottoTickets.add(new LottoTicket(lottoTicketText));
            }
            return lottoTickets;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return generateManualLottoTicket(ticketCount);
        }
    }

    private List<LottoTicket> generateAutoLottoTickets(int ticketCount) {
        try {
            List<LottoTicket> lottoTickets = new ArrayList<>();
            for (int i = 0; i < ticketCount; i++) {
                lottoTickets.add(new LottoTicket());
            }
            return lottoTickets;
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

    private WinningLottoTicket generateWinningLottoTicket(LottoTicket winningTicket) {
        try {
            int bonusNumber = inputView.inputBonusBall(); //보너스 볼 입력
            return new WinningLottoTicket(winningTicket, bonusNumber);
        } catch (NumberFormatException nfe) {
            System.out.println(ErrorCode.INPUT_MISS_MATCHED.getErrorMessage());
            return generateWinningLottoTicket(winningTicket);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            return generateWinningLottoTicket(winningTicket);
        }
    }

}
