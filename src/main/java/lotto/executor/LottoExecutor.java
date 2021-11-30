package lotto.executor;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.RandomLottoNumberStrategy;
import lotto.domain.winning.WinningLottoStats;
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

        ResultView.printView("\n" + "당첨 통계\n" + "------");

        WinningLottoStats winningLottoStats = new WinningLottoStats(lottos, new Lotto(winningNumList));

        ResultView.printWinningStatsView(winningLottoStats);
        ResultView.printView("총 수익률은 " + winningLottoStats.getProfitPercent(totalPurchaseAmount) + "입니다.");
    }
}
