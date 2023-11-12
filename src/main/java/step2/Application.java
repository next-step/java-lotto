package step2;

import step2.view.InputView;
import step2.view.LottoResultView;

import java.util.List;

public class Application {

    private static final InputView inputView = new InputView();
    private static final LottoResultView lottoResultView = new LottoResultView();

    public static void main(String[] args) {
        List<Lotto> totalLotto = new LottoMachine().createLottos(inputView.inputMoney());

        lottoResultView.printPurchaseComplete(totalLotto.size());
        lottoResultView.printList(totalLotto);

        int[] winningNumbers = inputView.inputWinningNumber();
        lottoResultView.printResult(winningNumbers, totalLotto);
    }
}
