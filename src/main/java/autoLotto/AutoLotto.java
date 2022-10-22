package autoLotto;

public class AutoLotto {
    private static final int LOTTO_PRICE = 1000;

    public static void run() {
        Lottos lottos = new Lottos();
        Quantity quantity = new Quantity(InputView.inputAmount());

        int countOfLotto = quantity.getQuantity();
        OutputView.outputQuantity(countOfLotto);

        for (int i = 0 ; i < countOfLotto ; i++) {
            lottos.addLotto(new Lotto());
        }

        OutputView.outputLottos(lottos);

        WinningNumbers winningNumbers = new WinningNumbers(InputView.inputNumbers(), InputView.inputBonusNumber());
        double result = Calculator.calculate(lottos, winningNumbers, countOfLotto * LOTTO_PRICE);

        OutputView.outputResult(new GameResult(result));
    }
}
