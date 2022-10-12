package lotto;

import java.math.BigDecimal;
import java.util.Map;

import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.WinningNumber;
import lotto.service.LottoFactory;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoFactory lottoFactory;
    private final Calculator calculator;

    public LottoController(InputView inputView, OutputView outputView, LottoFactory lottoFactory,
                           Calculator calculator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoFactory = lottoFactory;
        this.calculator = calculator;
    }

    public void startLotto() {
        BigDecimal payAmount = inputView.inputPayAmount();
        Lotto lotto = lottoFactory.generateLotto(payAmount);
        outputView.printPurchasedLotto(lotto);

        WinningNumber winningNumber = inputView.inputBeforeWinningNumber();
        Map<Prize, Integer> lottoRankMap = winningNumber.calcLottoRank(lotto);
        outputView.printStatisticLotto(lottoRankMap);

        BigDecimal prizeMoney = calculator.calculatePrizeMoney(lottoRankMap);
        outputView.printYield(calculator.calculateYield(payAmount, prizeMoney));
    }
}
