package step3.controller;

import step3.domain.LottoService;
import step3.domain.LottoStoreService;
import step3.domain.ProfitCalculatorService;
import step3.domain.model.Lotto.Lottos;
import step3.domain.strategy.price.LottoPriceStrategy;
import step3.view.InputView;
import step3.view.OutputView;

public class LottoController {
    public static void main(String[] args) {
        LottoStoreService lottoStoreService = LottoStoreService.createLottoStoreService();
        LottoService lottoService = LottoService.createLottoService();

        // 금액
        int purchaseAmount = InputView.askPurchaseAmount();
        // 수동 로또
        int manualLottoCount = InputView.askManualLottoCount();
        Lottos manualLotto = lottoService.createManualLotto(InputView.askManualLotto(manualLottoCount));
        OutputView.outPutLottos(manualLotto);

        int remainingMoneyAfterBuyLotto = lottoStoreService.getRemainingMoneyAfterBuyLotto(new LottoPriceStrategy(), purchaseAmount, manualLottoCount);
        // 자동 로또
        int autoLottoCount = lottoStoreService.getAutoLottoCount(new LottoPriceStrategy(), remainingMoneyAfterBuyLotto);
        OutputView.outPut(autoLottoCount);
        Lottos lottos = lottoService.createAutoLottos(autoLottoCount, manualLotto);
        OutputView.outPutLottos(lottos);

        // 당첨 번호
        lottoService.calculatorWinning(lottos, LottoService.createWinningLotto(InputView.askLastWeekWinningNumbers()));
        // 보너스 번호
        lottoService.calculatorBonusNumber(lottos, lottoService.createBonusNumber(InputView.askBonusNumber()));

        // 계산
        ProfitCalculatorService profitCalculatorService = ProfitCalculatorService.createProfitCalculatorService();
        OutputView.outPutProfit(profitCalculatorService.calculatorProfit(lottos, purchaseAmount), profitCalculatorService.getWinningLotto(lottos));
    }
}
