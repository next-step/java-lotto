package lotto.controller;

import lotto.domain.*;
import lotto.utils.StatisticsExporter;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public LottoTickets purchaseLottoTickets() {
        final Money money = inputView.getPurchaseAmount();
        final LottoCount lottoCount = inputView.getManualLottoCount(money);
        final ManualNumbersPicker manualNumbersPicker = inputView.getManualPickedNumberLines(lottoCount);
        final AutoNumbersPicker autoNumbersPicker = new AutoNumbersPicker();
        final LottoPurchase lottoPurchase = new LottoPurchase(autoNumbersPicker, manualNumbersPicker, money);

        return new LottoTickets(lottoPurchase);
    }

    public void printLottoTickets(final LottoTickets lottoTickets) {
        outputView.printLottoTickets(lottoTickets);
    }

    public GoldenTicket pickGoldenTicket(){
        final LottoTicket winningTicket = inputView.getWinningTicketNumbers();
        final LottoNumber bonusNumber = inputView.getBonusNumber();

        try {
            return new GoldenTicket(winningTicket, bonusNumber);
        }catch (Exception exception){
            exception.printStackTrace();
            return pickGoldenTicket();
        }
    }

    public void printResults(final LottoTickets lottoTickets, final GoldenTicket goldenTicket) {
        final WinnerStatistics winnerStatistics = new WinnerStatistics(goldenTicket, lottoTickets);
        final StatisticsExporter statisticsExporter = new StatisticsExporter(winnerStatistics);
        outputView.printStatistics(statisticsExporter);
    }
}