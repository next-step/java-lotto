package lotto;

public class Application {

    public static void main(String[] args) {
        LottoMachine machine = new LottoMachine();
        Lottos lottos = machine.issue(InputView.getPaid());
        ResultView.printLottos(lottos);

        LottoResults results = lottos.checkResults(InputView.askWinningNumbers(), InputView.askBonusNumber());
        ResultView.printResults(results);
    }
}
