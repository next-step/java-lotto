package lotto;

public class Application {

    public static void main(String[] args) {
        int paidMoney = InputView.getPaid();
        LottoMachine machine = new LottoMachine();
        Lottos lottos = machine.issue(paidMoney);
        ResultView.printLottos(lottos);

        WinningNumbers winningNumbers = InputView.askWinningNumbers();
        LottoResults results = lottos.checkResults(winningNumbers);
        ResultView.printResults(results);
    }
}
