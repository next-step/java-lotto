package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.LottoPlay;
import lotto.domain.RandomLottoGenerator;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoProcessor {

    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();

    public static void main(String[] args) {

        try {
            final LottoPlay lottoPlay = new LottoPlay(inputView.getTotalPrice(),
                new RandomLottoGenerator());
            resultView.printNumberOfLotto(lottoPlay.getLottoCounts());
            resultView.printLottoTickets(lottoPlay.getLottoTickets());

            lottoPlay.run(new LottoMachine(inputView.getWinNumbers(), inputView.getBonusNumber()));

            resultView.printAnalyzeResults(lottoPlay.getWinningPrices(),
                lottoPlay.calculateProfitPercent());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
