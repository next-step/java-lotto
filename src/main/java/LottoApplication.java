import domain.*;
import view.InputView;
import view.ResultView;

import java.util.Scanner;

public class LottoApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        Cash cash = inputView.scanCashWithAnnouncement();
        LottoNumbersList lottoNumbersList = inputView.scanManualLottoNumbers(cash);
        LottoMachine lottoMachine = new LottoMachine(new ManualSelectRule(lottoNumbersList, new RandomSelectRule()));
        Lottos lottos = lottoMachine.issue(cash);
        InputView.printLottos(lottos);
        ResultView resultView = new ResultView(new Scanner(System.in));
        Winner winner = resultView.scanWinner();
        LottoResult lottoResult = LottoResult.create(winner, lottos);
        ResultView.printLottoResult(lottoResult);
    }
}
