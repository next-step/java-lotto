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
        int purchaseAmount = InputView.askPurchaseAmount();
        int lottoCount = LottoStoreService.createLottoStoreService()
                .getLottoCount(new LottoPriceStrategy(), purchaseAmount);

        OutputView.outPut(lottoCount);
        // 로또 서비스 생성
        LottoService lottoService = LottoService.createLottoService();
        // 로또 생성
        Lottos lottos = lottoService.createLottos(lottoCount);
        OutputView.outPutLottos(lottos);

        InputView.newLineRemove();

        // 당첨 번호
        lottoService.calculatorWinning(lottos, LottoService.createWinningLotto(InputView.askLastWeekWinningNumbers()));
        // 보너스 번호
        lottoService.calculatorBonusNumber(lottos, lottoService.createBonusNumber(InputView.askBonusNumber()));

        // 계산
        ProfitCalculatorService profitCalculatorService = ProfitCalculatorService.createProfitCalculatorService();
        OutputView.outPutProfit(profitCalculatorService.calculatorProfit(lottos, purchaseAmount), profitCalculatorService.getWinningLotto(lottos));
    }
}
