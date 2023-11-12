package step2;

import step2.domain.LottoMachine;
import step2.domain.Lottos;
import step2.view.InputView;
import step2.view.LottoResultView;


public class Application {

    public static void main(String[] args) {
        Lottos lottos = new LottoMachine().createLottos(InputView.inputMoney());
        LottoResultView.printPurchaseComplete(lottos);

        int[] winningNumbers = InputView.inputWinningNumber();
        LottoResultView.printResult(winningNumbers, lottos.getLottos());
    }
}
