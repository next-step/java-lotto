package lotto.controller;

import lotto.domain.*;
import lotto.dto.ResponseLottosDTO;
import lotto.dto.ResponseWinningDTO;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    public void start() {
        int purchaseAmount = InputView.inputPurchaseAmount();
        Lottos lottos = Lottos.of(purchaseAmount);
        int purchaseCount = lottos.getSize();

        ResultView.printPurchaseCount(purchaseCount);

        printLottosForCount(purchaseCount, lottos);

        ResultView.printWinningStatistics(exportResponseWinningDTO(lottos, purchaseAmount));
    }

    private void printLottosForCount(int count, Lottos lottos) {
        for (int i = 0; i < count; i++) {
            ResultView.printLottoNumber(new ResponseLottosDTO(lottos.getLottos().get(i).getLottoNumbers()));
        }
    }

    private ResponseWinningDTO exportResponseWinningDTO(Lottos lottos, int purchaseAmount) {
        WinningNumber winningNumber = new WinningNumber(InputView.inputLastWeekWinningNumber());
        Hit hit = lottos.getWinnerStatistics(winningNumber);
        double yield = Yield.calculateYield(purchaseAmount, hit.getTotalWinningAmount());

        return new ResponseWinningDTO(hit.getHit(), yield);
    }
}
