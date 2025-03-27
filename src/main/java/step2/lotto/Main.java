package step2.lotto;

import java.util.List;
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
        ResultView.showLottos(lottos);

        List<Integer> winningLotto = InputView.lastWeekLottoNumbers();
        Statistic stat = game.play(winningLotto);

        ResultView.showStatistics(stat, paidMoney);

    }

}
