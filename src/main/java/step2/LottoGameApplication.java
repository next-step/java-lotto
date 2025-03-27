package step2;

import step2.domain.LottoGame;
import step2.domain.LottoGameResult;
import step2.domain.lotto.LottoFactory;
import step2.domain.lotto.LottoGenerator;
import step2.domain.lotto.LottoStatistics;
import step2.domain.lotto.WinningLotto;
import views.InputView;

import java.util.List;

public class LottoGameApplication {

    public static void main(String[] args) {
        Integer purchaseAmount = InputView.promptForInteger("구입금액을 입력해 주세요.");

        List<Integer> winningNumbers = InputView.promptForIntegerList("지난 주 당첨 번호를 입력해 주세요.");


        LottoGenerator lottoGenerator = new LottoGenerator(1, 45, 6);
        LottoFactory lottoFactory = new LottoFactory(lottoGenerator);
        WinningLotto winningLotto = new WinningLotto(winningNumbers);
        LottoGame lottoGame = new LottoGame(purchaseAmount, 1000, winningLotto, lottoFactory);
        LottoGameResult lottoGameResult = lottoGame.play();

        LottoStatistics lottoStatistics = new LottoStatistics(purchaseAmount);
        lottoStatistics.getWinningRate(lottoGameResult.getWinningsSum());
    }
}
