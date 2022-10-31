package lotto;

import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        LottoPrice lottoPrice = getLottoPrice();
        LottoStore lottoStore = new LottoStore(lottoPrice);
        int purchasePrice = InputView.queryPurchasePrice();
        List<LottoTicket> lottoTickets = lottoStore.purchase(purchasePrice);
        LottoRound lottoRound = new LottoRound(lottoTickets);
        ResultView.printLottoTickets(lottoTickets);

        List<Integer> winningNumbers = InputView.queryWinningNumbers();
        LottoTicket winningTicket = LottoTicket.from(winningNumbers);
        List<LottoWinner> winners = lottoRound.getWinners(winningTicket);

        LottoWinnerStat winnerStat = new LottoWinnerStat(lottoTickets.size(), winners);
        LottoPrizeInfo prizeInfo = getPrizeInfo();
        double profitMargin = winnerStat.getProfitMargin(lottoPrice, prizeInfo);
        ResultView.printWinnerStat(winnerStat, prizeInfo);
        ResultView.printProfitMargin(profitMargin);
    }

    private static LottoPrice getLottoPrice() {
        return new LottoPrice(1000);
    }

    private static LottoPrizeInfo getPrizeInfo() {
        return new LottoPrizeInfo(Map.of(
                LottoWinnerClass.FIRST, 2000000000,
                LottoWinnerClass.SECOND, 1500000,
                LottoWinnerClass.THIRD, 50000,
                LottoWinnerClass.FOURTH, 5000
        ));
    }
}
