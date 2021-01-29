package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoApplication {

    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        int purchaseAmount = inputView.getPurchaseAmount();
        int purchaseCount = purchaseAmount / 1_000;
        outputView.printPurchaseCount(purchaseCount);

        List<LottoTicket> lottoTickets = IntStream
                .range(0, purchaseCount)
                .mapToObj(i -> new LottoTicket(LottoNumbersPicker.pick()))
                .collect(Collectors.toList());
        outputView.printLottoTickets(lottoTickets);

        LottoTicket winningTicket = inputView.getWinningTicket();
        LottoNumber bonusNumber = inputView.getBonusNumber();
        GoldenTicket goldenTicket = new GoldenTicket(winningTicket, bonusNumber);

        WinnerStatistics winnerStatistics = new WinnerStatistics(goldenTicket, lottoTickets);
        outputView.printStatistics(winnerStatistics, purchaseAmount);
    }
}
