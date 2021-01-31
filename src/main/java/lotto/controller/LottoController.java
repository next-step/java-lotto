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
        final NumberPicker numberPicker = new LottoNumbersPicker();
        final LottoPurchase lottoPurchase = new LottoPurchase(numberPicker, money.getAmount());

        return new LottoTickets(lottoPurchase);
    }

    public void printLottoTickets(final LottoTickets lottoTickets) {
        outputView.printLottoTickets(lottoTickets);
    }

    public LottoTicket makeWinningTicket() {
        final String[] winningTicketNumbers = inputView.getWinningTicketNumbers();
        return new LottoTicket(winningTicketNumbers);
    }

    public LottoNumber makeBonusBall() {
        final LottoNumber bonusNumber = inputView.getBonusNumber();
        return bonusNumber;
    }

    public void printResults(final LottoTickets lottoTickets, final LottoTicket winningTicket, final LottoNumber bonusNumber) {
        final GoldenTicket goldenTicket = new GoldenTicket(winningTicket, bonusNumber);
        final WinnerStatistics winnerStatistics = new WinnerStatistics(goldenTicket, lottoTickets);
        final StatisticsExporter statisticsExporter = new StatisticsExporter(winnerStatistics);
        outputView.printStatistics(statisticsExporter, lottoTickets);
    }
}