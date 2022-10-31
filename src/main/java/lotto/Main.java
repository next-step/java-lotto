package lotto;

import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        LottoStore lottoStore = new LottoStore();
        int purchasePrice = InputView.queryPurchasePrice();
        List<LottoTicket> lottoTickets = lottoStore.purchase(purchasePrice);
        LottoRound lottoRound = new LottoRound(lottoTickets);
        ResultView.printLottoTickets(lottoTickets);

        List<Integer> winningNumbers = InputView.queryWinningNumbers();
        LottoTicket winningTicket = LottoTicket.from(winningNumbers);
        List<LottoWinner> winners = lottoRound.getWinners(winningTicket);

        LottoWinnerStat winnerStat = new LottoWinnerStat(winners);
        ResultView.printWinnerStat(winnerStat);
    }
}
