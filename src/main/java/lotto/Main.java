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
        List<LottoResult> results = lottoRound.finishRound(winningTicket);

        LottoResultStat resultStat = new LottoResultStat(results);
        LottoPrizeInfo prizeInfo = getPrizeInfo();
        double profitMargin = resultStat.getProfitMargin(lottoPrice, prizeInfo);
        ResultView.printLottoResult(resultStat, prizeInfo);
        ResultView.printProfitMargin(profitMargin);
    }

    private static LottoPrice getLottoPrice() {
        return new LottoPrice(1000);
    }

    private static LottoPrizeInfo getPrizeInfo() {
        return new LottoPrizeInfo(Map.of(
                LottoResult.FIRST, 2000000000,
                LottoResult.SECOND, 1500000,
                LottoResult.THIRD, 50000,
                LottoResult.FOURTH, 5000
        ));
    }
}
