package step2.controller;

import step2.domain.LottoGames;
import step2.domain.LottoResultReport;
import step2.domain.LottoTicket;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LottoGameController {

    private LottoGames lottoGames = new LottoGames();

    public void playLottoGame() {

        int money = InputView.readAmountOfPurchase();
        int manualLottoTicketCount = InputView.readCountOfManualTicket();
        List<LottoTicket> manualLottoTickets = buyManualTickets(manualLottoTicketCount);

        int automaticTicketCount = lottoGames.calculateBuyingTicketCount(money, manualLottoTicketCount);
        ResultView.printNumberOfTickets(manualLottoTicketCount, automaticTicketCount);
        if (automaticTicketCount == 0 && manualLottoTicketCount == 0) {
            return;
        }

        List<LottoTicket> automaticLottoTickets = getBuyAutomaticTickets(automaticTicketCount);
        ResultView.printLottoTicket(automaticLottoTickets);
        LottoTicket winningTicket = readWinningTicket();
        int bonusNumber = InputView.readBonusNumber();

        ResultView.printBlankLine();
        ResultView.printMessage("당첨 통계");

        LottoResultReport lottoResultReport = getLottoResultReport(manualLottoTickets, automaticLottoTickets, winningTicket, bonusNumber);

        ResultView.printResultReport(lottoResultReport);
        double profit = lottoResultReport.calculateProfit(manualLottoTicketCount + automaticTicketCount);
        ResultView.printMessage("총 수익률은 " + profit + "입니다.");
    }

    private List<LottoTicket> buyManualTickets(int manualTicketCount) {
        ResultView.printMessage("수동으로 구매할 번호를 입력해 주세요");
        List<LottoTicket> manualLottoTickets = new ArrayList<>();
        for (int i = 0; i < manualTicketCount; i++) {
            manualLottoTickets.add(lottoGames.toLottoTicket(InputView.readManualTicketNumbers()));
        }
        return manualLottoTickets;
    }

    private List<LottoTicket> getBuyAutomaticTickets(int automaticTicketCount) {
        return lottoGames.buyAutomaticLottoTickets(automaticTicketCount);
    }

    private LottoTicket readWinningTicket() {
        ResultView.printMessage("지난 주 당첨 번호를 입력해 주세요");
        return lottoGames.toLottoTicket(InputView.readWinningNumbers());
    }

    private LottoResultReport getLottoResultReport(List<LottoTicket> manualLottoTickets, List<LottoTicket> automaticLottoTickets, LottoTicket winningTicket, int bonusNumber) {
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
