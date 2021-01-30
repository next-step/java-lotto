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

    public List<LottoTicket> purchaseLottoTickets() {
        int purchaseAmount = inputView.getPurchaseAmount();
        int purchaseCount = purchaseAmount / LOTTO_TICKET_PRICE;    // Purchase 객체 생성?
        outputView.printPurchaseCount(purchaseCount);

        List<LottoTicket> lottoTickets = IntStream
                .range(0, purchaseCount)
                .mapToObj(i -> new LottoTicket(LottoNumbersPicker.pick()))
                .collect(Collectors.toList());
        outputView.printLottoTickets(lottoTickets);
        return lottoTickets;
    }

    public void getWinner(List<LottoTicket> lottoTickets) {
        LottoTicket winningTicket = inputView.getWinningTicket();
        LottoNumber bonusNumber = inputView.getBonusNumber();
        GoldenTicket goldenTicket = new GoldenTicket(winningTicket, bonusNumber);
        int purchaseAmount = lottoTickets.size() * LOTTO_TICKET_PRICE;

        WinnerStatistics winnerStatistics = new WinnerStatistics(goldenTicket, lottoTickets);
        outputView.printStatistics(winnerStatistics, purchaseAmount);
    }
}