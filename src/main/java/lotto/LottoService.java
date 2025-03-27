package lotto;

import lotto.domain.LottoGame;
import lotto.domain.LottoTickets;
import lotto.strategy.AutoLottoStrategy;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class LottoService {
    public static void main(String[] args) {
        int lottoPrice = InputView.inputLottoPrice();
        int lottoCount = getLottoCount(lottoPrice);
        ResultView.viewLottoCount(lottoCount);

        LottoGame lottoGame = new LottoGame(LottoTickets.fromNumbers(lottoCount));
        lottoGame.generateAutoLottoNumbers(new AutoLottoStrategy());
        ResultView.viewLottoTickets(lottoGame);

        lottoGame.gameStart(InputView.inputWinningLottoNumbers());

        ResultView.viewWinningStatistics(lottoGame);
        ResultView.viewReturnStatistics(lottoGame.calculateReturnRate());

    }

    private static int getLottoCount(int lottoPrice) {
        return lottoPrice / 1000;
    }
}
