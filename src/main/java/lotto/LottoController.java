package lotto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;
    private final Calculator calculator;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService,
                           Calculator calculator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
        this.calculator = calculator;
    }

    public void startLotto() {
        BigDecimal payAmount = inputView.inputPayAmount();
        List<Lotto> lottos = lottoService.purchaseLotto(payAmount);
        outputView.printPurchasedLotto(lottos);
        List<Integer> winningNumber = inputView.inputBeforeWinningNumber();
        Map<Integer, Integer> lottoRankMap = lottoService.confirmLottoRank(lottos, winningNumber);
        outputView.printStatisticLotto(lottoRankMap);
        BigDecimal prizeMoney = calculator.calculatePrizeMoney(lottoRankMap);
        outputView.printYield(calculator.calculateYield(payAmount, prizeMoney));
    }
}
