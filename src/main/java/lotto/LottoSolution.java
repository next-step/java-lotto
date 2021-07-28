package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoList;
import lotto.view.DosInputView;
import lotto.view.DosResultView;
import lotto.view.InputView;
import lotto.view.ResultView;

public final class LottoSolution {
    public static void main(String[] args) {
        LottoSolution lottoSolution = new LottoSolution(
                new DosInputView(), new DosResultView()
        );
        lottoSolution.run();
    }

    private final InputView inputView;
    private final ResultView resultView;
    private final LottoController lottoController;

    private LottoSolution(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.lottoController = LottoController.getInstance();
    }

    private void run() {
        try {
            int money = inputView.inputMoney();
        } catch (Exception e) {
            resultView.printException(e);
        }
    }

    private LottoList buyLotto() {
        int money = inputView.inputMoney();
        return null;
    }
}
