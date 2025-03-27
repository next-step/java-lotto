package step2;

import step2.domain.lotto.LottoCount;
import step2.domain.LottoGame;
import step2.domain.LottoGameResult;
import step2.domain.lotto.*;
import views.InputView;
import views.ResultView;

import java.util.List;

public class LottoGameApplication {

    public static void main(String[] args) {
        LottoCount lottoCount = createLottoCountWithQuery();
        LottoGame lottoGame = setUpLottoGame(lottoCount);

        ResultView.printMessage("");
        ResultView.printMessage(lottoGame.toString());

        LottoGameResult lottoGameResult = playLottoRound(lottoGame);

        showGameSummary(lottoCount, lottoGameResult);
    }

    private static void showGameSummary(LottoCount lottoCount, LottoGameResult lottoGameResult) {
        double winningRate = lottoCount.getWinningRate(lottoGameResult.getWinningsSum());

        ResultView.printMessage("");
        ResultView.printResult(lottoGameResult);
        ResultView.printMessage(String.format("총 수익률은 %.2f입니다.", winningRate));
    }

    private static LottoGameResult playLottoRound(LottoGame lottoGame) {
        List<Integer> winningNumbers = InputView.promptForIntegerList("지난 주 당첨 번호를 입력해 주세요.", ",");
        WinningLotto winningLotto = new WinningLotto(winningNumbers);
        return lottoGame.play(winningLotto);
    }

    private static LottoGame setUpLottoGame(LottoCount lottoCount) {
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator(1, 45, 6);
        LottoFactory lottoFactory = new LottoFactory(lottoNumberGenerator);
        return new LottoGame(lottoCount, lottoFactory);
    }

    private static LottoCount createLottoCountWithQuery() {
        LottoCount lottoCount = null;
        while (lottoCount == null) {
            int purchaseAmount = InputView.promptForInteger("구입금액을 입력해 주세요.");
            lottoCount = createLottoCount(purchaseAmount);
        }
        return lottoCount;
    }

    private static LottoCount createLottoCount(int purchaseAmount) {
        try {
            return new LottoCount(purchaseAmount, 1000);
        } catch (IllegalArgumentException e) {
            ResultView.printMessage(e.getMessage());
        }
        return null;
    }
}
