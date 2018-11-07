package raffle.lotto.play;

import raffle.lotto.LottoMachine;
import raffle.lotto.win.LottoResult;
import raffle.view.InputView;
import raffle.view.ResultView;

public class PlayLotto {
    public static void main(String[] args) {
        ResultView resultView = new ResultView();
        LottoMachine lottoMachine = new LottoMachine(InputView.lottoAmount());
        resultView.buyLotto(lottoMachine.getLottos());

        LottoResult lottoResult = lottoMachine.winLotto(InputView.lastWeekLotto());
        resultView.result(lottoResult);

    }
}
