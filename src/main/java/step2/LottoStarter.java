package step2;

import step2.domain.LottoGenerator;
import step2.domain.strategy.RandomLottoGeneratorStrategy;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.List;

public class LottoStarter {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        int lottoAmount = inputView.getLottoAmount(inputView.getPurchaseAmount());
        LottoGenerator lottoGenerator = new LottoGenerator(lottoAmount, new RandomLottoGeneratorStrategy());
        lottoGenerator.generate();

        resultView.showLottos(lottoGenerator.getLottoTicket());

        List<String> lottoWinningNumber = inputView.getWinningNumbers();
        lottoGenerator.calcLottoWinCount(lottoWinningNumber);
        resultView.showWinResult(lottoGenerator.getLottoWinCount());
        resultView.showWinRatio(lottoGenerator.calcWinnerRatio(lottoAmount, lottoGenerator.calcTotalPrice()));
    }
}
