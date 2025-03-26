package step2.lotto;

import step2.lotto.domain.Lotto;
import step2.lotto.domain.Lottos;
import step2.lotto.domain.Statistic;
import step2.lotto.game.Game;
import step2.lotto.view.InputView;
import step2.lotto.view.ResultView;

public class Main {

    public static void main(String[] args) {
        int paidMoney = InputView.getPaidMoney();

        Game game = new Game();
        Lottos lottos = game.createLottos(paidMoney);
        ResultView.showGameCount(lottos.size());
        ResultView.showLottos(lottos);

        Lotto winningLotto = InputView.lastWeekLottoNumbers();
        Statistic stat = game.play(winningLotto);

        ResultView.showStatistics(stat, paidMoney);

    }

}
