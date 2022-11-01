package lotto;

import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.List;

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
        double profitMargin = resultStat.getProfitMargin(lottoPrice);
        ResultView.printLottoResults(resultStat);
        ResultView.printProfitMargin(profitMargin);
    }

    private static LottoPrice getLottoPrice() {
        return new LottoPrice(1000);
    }
}
