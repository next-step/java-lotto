package lotto;

public class Application {

    public static void main(String[] args) {
        LottoMachine machine = new LottoMachine();
        LottoIssueRequest lottoIssueRequest = new LottoIssueRequest(InputView.getPaid(), InputView.askManualNumbers());
        LottoIssueResponse lottoIssueResponse = machine.issue(lottoIssueRequest);
        ResultView.printLottos(lottoIssueResponse);

        Lottos lottos = lottoIssueResponse.getLottos();
        LottoResults results = lottos.checkResults(InputView.askWinningNumbers(), InputView.askBonusNumber());
        ResultView.printResults(results);
    }
}
