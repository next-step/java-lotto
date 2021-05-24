package lotto;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoManager {
    private InputView inputView;
    private ResultView resultView;

    public LottoManager(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        LottoManager manager = new LottoManager(inputView,resultView);

        manager.playLotto();
    }

    private void playLotto() {
        int money = inputView.takeMoney();

        Lottos lottos = new Lottos(money);

        resultView.showLottoGames(lottos);

        int[] lottoNumbers = inputView.takeLottoNumbers();

        resultView.showLottoStatics(lottos.calculateStatics(new Lotto(lottoNumbers)));
    }
}
