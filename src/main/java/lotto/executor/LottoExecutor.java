package lotto.executor;

import lotto.domain.LottoScores;
import lotto.domain.Lottos;
import lotto.domain.number.RandomLottoNumberStrategy;
import lotto.domain.Ranks;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoExecutor {


    public static void main(String[] args) {

        int totalPurchaseAmount = InputView.getNumberInput("구입금액을 입력해 주세요.");
        int lottoCount = Lottos.getLottoCount(totalPurchaseAmount);

        ResultView.printView(lottoCount + "개를 구매했습니다.");
        Lottos lottos = Lottos.createLottos(lottoCount, new RandomLottoNumberStrategy());
        ResultView.printLottoNumberView(lottos);

        ResultView.printView("\n");

        String winningString = InputView.getInput("지난 주 당첨 번호를 입력해 주세요.");
        List<Integer> winningNumList = InputView.getNumberListFromString(winningString);

        int bonusBall = InputView.getNumberInput("보너스 볼을 입력해 주세요.");

        ResultView.printView("\n" + "당첨 통계\n" + "------");

        LottoScores lottoScores = new LottoScores(lottos, new WinningLotto(winningNumList, bonusBall));
        Ranks ranks = new Ranks(lottoScores);

        ResultView.printWinningStatsView(ranks);
        ResultView.printView("총 수익률은 " + ranks.getProfitPercent(totalPurchaseAmount) + "입니다.");
    }
}
