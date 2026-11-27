import domain.*;
import view.InputView;
import view.ResultView;

import java.util.List;

public class LottoApplication {

    public static void main(String[] args) {


        int amount = InputView.inputAmount();
        Lottos lottos = new Lottos(amount);

        ResultView.printPurchaseCount(lottos.size());
        ResultView.printLottos(lottos.getLottoList());


        Lotto winningLotto1 = new Lotto(InputView.inputWinningNumbers());
        LottoNumber bonusNumber = new LottoNumber(InputView.inputBonusNumber());


        WinningLotto winningLotto = new WinningLotto(winningLotto1, bonusNumber);

        List<Rank> ranks = lottos.checkResult(winningLotto);

        WinningStatistics winningStatistics = new WinningStatistics(ranks);

        ResultView.printStatistics(winningStatistics);
        ResultView.printProfitRate(winningStatistics.profitRate(amount));

    }
}
