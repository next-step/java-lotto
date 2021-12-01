package lotto;

import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Integer lottoCount = inputView.inputCount();

        LottoController controller = new LottoController();
        List<LottoPaper> lottoPapers = controller.purchaseLotto(lottoCount);
        lottoPapers.forEach(outputView::printLottoPaper);


        WinningNumbers winningNumbers = inputView.inputWinningNumbers();

        LottoResult result = new LottoResult(lottoPapers, winningNumbers);
        outputView.printStatistics(result);
    }
}
