package autoLotto;

import java.util.List;

public class AutoLotto {

    public static void run() {
        List<Lotto> lottoList = LottoFactory.makeLotto(InputView.inputAmount());
        Lottos lottos = new Lottos(lottoList);
        GameResult result = new GameResult();

        OutputView.outputQuantity(lottos);

        OutputView.outputLottos(lottos);

        WinningNumbers winningNumbers = new WinningNumbers(InputView.inputNumbers(), InputView.inputBonusNumber());
        Calculator.calculate(lottos, winningNumbers, result);
        OutputView.outputResult(result);
    }
}
