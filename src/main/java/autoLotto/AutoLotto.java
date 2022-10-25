package autoLotto;

public class AutoLotto {

    public static void run() {
        Lottos lottos = new Lottos(InputView.inputAmount());
        GameResult result = new GameResult();

        OutputView.outputQuantity(lottos);

        OutputView.outputLottos(lottos);

        WinningNumbers winningNumbers = new WinningNumbers(InputView.inputNumbers(), InputView.inputBonusNumber());
        Calculator.calculate(lottos, winningNumbers, result);
        OutputView.outputResult(result);
    }
}
