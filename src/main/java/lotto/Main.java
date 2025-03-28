package lotto;

import java.util.List;
import lotto.domain.Lottos;
import lotto.domain.Statistic;
import lotto.game.Game;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Main {

    public static void main(String[] args) {
        int paidMoney = InputView.getPaidMoney();
        int bonusNumber = InputView.getBonusNumber();

        Game game = new Game();
        Lottos lottos = game.createLottos(paidMoney);
        ResultView.showLottos(lottos);

        List<Integer> winningLotto = InputView.lastWeekLottoNumbers();
        Statistic stat = game.play(winningLotto);

        ResultView.showStatistics(stat, paidMoney);

    }

}
