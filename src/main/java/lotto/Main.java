package lotto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNum;
import lotto.domain.Statistic;
import lotto.game.Game;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Main {

    public static void main(String[] args) {
        int paidMoney = InputView.getPaidMoney();
        int manualCount = InputView.getManualCount();
        Game game = new Game(paidMoney, manualCount);
        List<Lotto> manualLottoNumbers = InputView.getManualLottoNumbers(manualCount);
        game.generateLottos(manualLottoNumbers);
        ResultView.showLottos(game.lottos());

        List<LottoNum> winningLotto = InputView.lastWeekLottoNumbers();
        int bonusNumber = InputView.getBonusNumber();
        Statistic stat = game.play(winningLotto, bonusNumber);

        ResultView.showStatistics(stat);
    }

}
