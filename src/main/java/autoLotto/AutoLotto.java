package autoLotto;

public class AutoLotto {

    public static void run() {
        Lottos lottos = new Lottos(InputView.inputAmount());

        OutputView.outputQuantity(lottos);

        OutputView.outputLottos(lottos);

        WinningNumbers winningNumbers = new WinningNumbers(InputView.inputNumbers(), InputView.inputBonusNumber());
        double result = Calculator.calculate(lottos, winningNumbers);
        GameResult gameResult = new GameResult(result);

        OutputView.outputResult(gameResult);
    }
}
