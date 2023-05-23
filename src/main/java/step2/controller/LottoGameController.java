package step2.controller;

import step2.domain.*;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LottoGameController {

    private static final int LOTTO_TICKET_PRICE = 1000;
    private LottoGames lottoGames = new LottoGames();

    public void playLottoGame() {
        Money balance = new Money(InputView.readMoney());

        List<LottoTicket> manualLottoTickets = buyManualTickets(balance);
        List<LottoTicket> automaticLottoTickets = getBuyAutomaticTickets(balance);

        ResultView.printNumberOfTickets(manualLottoTickets.size(), automaticLottoTickets.size());
        if (manualLottoTickets.size() == 0 && automaticLottoTickets.size() == 0) {
            return;
        }
        ResultView.printLottoTicket(automaticLottoTickets);
        LottoTicket winningTicket = readWinningTicket();
        LottoNo bonusNumber = LottoNo.of(InputView.readBonusNumber());

        printResultStatistic(getLottoResultReport(manualLottoTickets, automaticLottoTickets, winningTicket, bonusNumber));
    }

    private List<LottoTicket> buyManualTickets(Money money) {
        int manualTicketCount = getManualTicketCount(money);
        money.pay(manualTicketCount * LOTTO_TICKET_PRICE);

        ResultView.printMessage("수동으로 구매할 번호를 입력해 주세요");
        List<LottoTicket> manualLottoTickets = new ArrayList<>(manualTicketCount);
        for (int i = 0; i < manualTicketCount; i++) {
            LottoTicket lottoTicket = lottoGames.toLottoTicket(InputView.readManualTicketNumbers());
            manualLottoTickets.add(lottoTicket);
        }
        return manualLottoTickets;
    }

    private int getManualTicketCount(Money money) {
        int manualTicketCount = InputView.readCountOfManualTicket();
        int cost = manualTicketCount * LottoCommonValue.DEFAULT_LOTTO_NUMBER_COUNT.value();
        money.pay(cost);
        return manualTicketCount;
    }

    private List<LottoTicket> getBuyAutomaticTickets(Money money) {
        int automaticTicketCount = money.balance() / LOTTO_TICKET_PRICE;
        money.pay(automaticTicketCount * LOTTO_TICKET_PRICE);
        return lottoGames.buyAutomaticLottoTickets(automaticTicketCount);
    }

    private LottoTicket readWinningTicket() {
        ResultView.printMessage("지난 주 당첨 번호를 입력해 주세요");
        return lottoGames.toLottoTicket(InputView.readWinningNumbers());
    }

    private void printResultStatistic(LottoResultReport lottoResultReport) {
        ResultView.printBlankLine();
        ResultView.printMessage("당첨 통계");
        ResultView.printResultReport(lottoResultReport);
        ResultView.printMessage("총 수익률은 " + lottoResultReport.calculateProfit() + "입니다.");
    }

    private LottoResultReport getLottoResultReport(List<LottoTicket> manualLottoTickets,
                                                   List<LottoTicket> automaticLottoTickets,
                                                   LottoTicket winningTicket, LottoNo bonusNumber) {

        LottoResultReport lottoResultReport = new LottoResultReport();
        for (LottoTicket lottoTicket : manualLottoTickets) {
            lottoResultReport.recordRank(lottoTicket.checkLottoTicket(winningTicket, bonusNumber));
        }
        for (LottoTicket lottoTicket : automaticLottoTickets) {
            lottoResultReport.recordRank(lottoTicket.checkLottoTicket(winningTicket, bonusNumber));
        }
        return lottoResultReport;
    }
}
