package step2.controller;

import step2.domain.LottoService;
import step2.domain.LottoStoreService;
import step2.domain.model.Lotto;
import step2.domain.strategy.lotto.LottoPolicyStrategy;
import step2.domain.strategy.price.LottoPriceStrategy;
import step2.view.InputView;
import step2.view.OutputView;

import java.util.List;

public class LottoController {
    public static void main(String[] args) {

        int lottoCount = LottoStoreService.createLottoStoreService()
                .getLottoCount(new LottoPriceStrategy(), InputView.askPurchaseAmount());
        OutputView.outPut(lottoCount);

        InputView.newLineRemove();

        String lastWinningNumbers = InputView.askLastWeekWinningNumbers();

        LottoService lottoService = LottoService.createLottoService(new LottoPolicyStrategy(), lottoCount, lastWinningNumbers);
        lottoService.calculatorLottoWinningCount();
        List<Lotto> lottos = lottoService.getLottos();
    }
}
