package lotto;

public class Application {

    public static void main(String[] args) {
        LottoMachine machine = new LottoMachine();
        LottoIssueRequest request = new LottoIssueRequest(InputView.getPaid(), InputView.askManualNumbers());
        Lottos lottos = machine.issue(request);
        ResultView.printLottos(lottos);

        LottoResults results = lottos.checkResults(InputView.askWinningNumbers(), InputView.askBonusNumber());
        ResultView.printResults(results);
    }
}
