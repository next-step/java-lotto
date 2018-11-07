package raffle.lotto.play;

import raffle.lotto.RandomLotto;
import raffle.view.InputView;
import raffle.view.ResultView;

public class PlayLotto {
    public static void main(String[] args) {
        ResultView resultView = new ResultView();
        RandomLotto randomLotto = new RandomLotto(InputView.lottoAmount());
        resultView.buyLotto(randomLotto.getLottoList());

        InputView.lastWeekLotto();
    }
}
