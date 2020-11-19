package step2;

import step2.controller.LottoController;
import step2.domain.LottoWinning;
import step2.view.LottoInputUi;
import step2.view.LottoOuputUi;

public class LottoApplicationMain {
    public static void main(String[] args) {

        int purchaseAmount = LottoInputUi.inputPurchaseAmount();
        LottoController lottoController = LottoController.of(purchaseAmount);

        LottoOuputUi.printLottoCount(lottoController.lottoPurchaseQty());
        LottoOuputUi.printLottos(lottoController.getLottos());

        String lastWeekWinningNumbers = LottoInputUi.inputLastWeekNumber();

        LottoWinning lottoWinning = LottoWinning.of(lastWeekWinningNumbers, lottoController.getLottos());
        LottoOuputUi.printWinningStatistics(lottoWinning.getLottoWinningMap());
        LottoOuputUi.printTotalReturn(lottoController.getTotalYield(lottoWinning.getWinningAmount()));
        LottoInputUi.close();
    }
}
