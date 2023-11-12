package step2;

import step2.view.InputView;
import step2.view.LottoResultView;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        List<Lotto> totalLotto = new LottoMachine().createLottos(InputView.inputMoney());

        LottoResultView.printPurchaseComplete(totalLotto.size());
        LottoResultView.printList(totalLotto);

        int[] winningNumbers = InputView.inputWinningNumber();
        LottoResultView.printResult(winningNumbers, totalLotto);
    }
}
