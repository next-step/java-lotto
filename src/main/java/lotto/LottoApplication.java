package lotto;

import lotto.model.LottoRequest;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoRequest request = inputView.inputLottoRequest();

        LottoController controller = new LottoController();
        List<LottoPaper> lottoAutoPapers =
                controller.purchaseAutoLotto(request.getPurchasedAutoCount());

        List<LottoPaper> lottoManualPapers =
                controller.purchaseManualLotto(request.getPurchasedManualLottoNumbers());

        List<LottoPaper> allLottoPapers = new ArrayList<>();
        allLottoPapers.addAll(lottoAutoPapers);
        allLottoPapers.addAll(lottoManualPapers);

        allLottoPapers.forEach(outputView::printLottoPaper);

        WinningNumbers winningNumbers = inputView.inputWinningNumbers();

        LottoResult result = new LottoResult(allLottoPapers, winningNumbers);
        outputView.printStatistics(result);
    }
}
