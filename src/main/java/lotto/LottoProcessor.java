package lotto;

import lotto.domain.LottoPlay;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoProcessor {

    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();

    public static void main(String[] args) {

        try {
            final LottoPlay lottoPlay = new LottoPlay(inputView);
            resultView.printNumberOfLotto(lottoPlay.getLottoCounts());
            resultView.printLottoTickets(lottoPlay.getLottoTickets());

            lottoPlay.run();

            resultView.printAnalyzeResults(lottoPlay.getWinningPrices(),
                lottoPlay.calculateProfitPercent());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
