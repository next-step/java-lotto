package step3.controller;

import step3.domain.LottoService;
import step3.domain.LottoStoreService;
import step3.domain.ProfitCalculatorService;
import step3.domain.model.Lotto.Lotto;
import step3.domain.strategy.price.LottoPriceStrategy;
import step3.view.InputView;
import step3.view.OutputView;

public class LottoController {
    public static void main(String[] args) {
        int purchaseAmount = InputView.askPurchaseAmount();
        int lottoCount = LottoStoreService.getLottoCount(new LottoPriceStrategy(), purchaseAmount);
        OutputView.outPut(lottoCount);

        LottoService lottoService = LottoService.of(lottoCount);
        OutputView.outPutLottos(lottoService.getLottos());

        InputView.newLineRemove();

        Lotto winningLotto = LottoService.createWinningLotto(InputView.askLastWeekWinningNumbers());
        lottoService.calculatorLottoWinning(winningLotto);

        ProfitCalculatorService from = ProfitCalculatorService.of(lottoService.getLottos(), purchaseAmount);
        OutputView.outPutProfit(from.getProfit(), from.getWinningResult());
    }
}
