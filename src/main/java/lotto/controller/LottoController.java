package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoController {
    private final int LOTTO_TICKET_PRICE = 1_000;

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public LottoTickets purchaseLottoTickets() {
        int purchaseAmount = inputView.getPurchaseAmount();
        final NumberPicker numberPicker = new LottoNumbersPicker();
        final LottoPurchase lottoPurchase = new LottoPurchase(numberPicker, purchaseAmount);
        final LottoTickets lottoTickets = new LottoTickets(lottoPurchase);


        outputView.printPurchaseCount(lottoTickets);
        outputView.printLottoTickets(lottoTickets);
        return lottoTickets;
    }

    public void getWinner(LottoTickets lottoTickets) {
        LottoTicket winningTicket = inputView.getWinningTicket();
        LottoNumber bonusNumber = inputView.getBonusNumber();
        GoldenTicket goldenTicket = new GoldenTicket(winningTicket, bonusNumber);


        WinnerStatistics winnerStatistics = new WinnerStatistics(goldenTicket, lottoTickets);
        outputView.printStatistics(winnerStatistics, lottoTickets);
    }
}