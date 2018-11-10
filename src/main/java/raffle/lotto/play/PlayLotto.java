package raffle.lotto.play;

import raffle.lotto.LottoMachine;
import raffle.lotto.win.LottoResult;
import raffle.view.InputView;
import raffle.view.ResultView;

public class PlayLotto {
    public static void main(String[] args) {
        ResultView resultView = new ResultView();
        int lottoCount = InputView.buyLotto();
        LottoMachine lottoMachine = new LottoMachine(InputView.lottoAmount() ,InputView.getLottoNumber(lottoCount));
        resultView.buyLotto(lottoMachine.getLottos(), lottoCount);

        LottoResult lottoResult = lottoMachine.winLotto(InputView.lastWeekLotto(), InputView.bonusLotto());
        resultView.result(lottoResult);

    }
}
