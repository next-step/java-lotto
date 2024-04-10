package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoApplication {

    public static void main(String[] args) {
        LottoFactory lottoFactory = new LottoFactory();
        int money = new InputView().getMoneyInput();

        List<Lotto> lottos = lottoFactory.issueTicketsByMoney(money);

        ResultView resultView = new ResultView();
        resultView.printLottoCount(lottos);
        resultView.printLottos(lottos);

        List<Integer> numbers = new InputView().getWinningLottoInput();
        int bonusNumber = new InputView().getBonusNumber();
        WinningLotto winningLotto = LottoFactory.createWinningLotto(numbers, bonusNumber);

        resultView.printWinningResult(lottoFactory.getRankResults(winningLotto, lottos));
        resultView.printRateOfReturn(lottoFactory.calculateRateOfReturn(winningLotto, lottos));
    }
}
