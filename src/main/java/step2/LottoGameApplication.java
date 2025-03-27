package step2;

import step2.domain.LottoGame;
import step2.domain.LottoGameResult;
import step2.domain.lotto.LottoFactory;
import step2.domain.lotto.LottoGenerator;
import step2.domain.lotto.LottoStatistics;
import step2.domain.lotto.WinningLotto;
import views.InputView;
import views.ResultView;

import java.util.List;

public class LottoGameApplication {

    public static void main(String[] args) {
        LottoGenerator lottoGenerator = new LottoGenerator(1, 45, 6);
        LottoFactory lottoFactory = new LottoFactory(lottoGenerator);

        int purchaseAmount = InputView.promptForInteger("구입금액을 입력해 주세요.");
        LottoGame lottoGame = new LottoGame(purchaseAmount, 1000, lottoFactory);

        ResultView.printMessage("");
        ResultView.printMessage(lottoGame.toString());

        List<Integer> winningNumbers = InputView.promptForIntegerList("지난 주 당첨 번호를 입력해 주세요.", ",");
        WinningLotto winningLotto = new WinningLotto(winningNumbers);
        LottoGameResult lottoGameResult = lottoGame.play(winningLotto);

        LottoStatistics lottoStatistics = new LottoStatistics(purchaseAmount);
        double winningRate = lottoStatistics.getWinningRate(lottoGameResult.getWinningsSum());

        ResultView.printMessage("");
        ResultView.printResult(lottoGameResult);
        ResultView.printMessage(String.format("총 수익률은 %.2f입니다.", winningRate));

    }
}
