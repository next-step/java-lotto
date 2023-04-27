package step2.controller;

import step2.domain.LottoService;
import step2.domain.LottoStoreService;
import step2.domain.ProfitCalculatorService;
import step2.domain.strategy.price.LottoPriceStrategy;
import step2.view.InputView;
import step2.view.OutputView;

public class LottoController {
    public static void main(String[] args) {

        int purchaseAmount = InputView.askPurchaseAmount();

        int lottoCount = LottoStoreService.createLottoStoreService()
                .getLottoCount(new LottoPriceStrategy(), purchaseAmount);

        OutputView.outPut(lottoCount);

        InputView.newLineRemove();

        String lastWinningNumbers = InputView.askLastWeekWinningNumbers();

        LottoService lottoService = LottoService.createLottoService(lottoCount, lastWinningNumbers);
        lottoService.calculatorLottoWinningCount();

        ProfitCalculatorService from = ProfitCalculatorService.from(lottoService.getLottos(), purchaseAmount);
        OutputView.outPutProfit(from.getProfit(), from.getWinningCount());
    }
}
