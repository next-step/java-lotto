package lotto;

import lotto.domain.LottoGame;
import lotto.domain.LottoGames;
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

        LottoGames lottoGames = new LottoGames(money);

        resultView.showLottoGames(lottoGames);

        int[] lottoNumbers = inputView.takeLottoNumbers();

        resultView.showLottoStatics(lottoGames.calculateStatics(new LottoGame(lottoNumbers)));
    }
}
