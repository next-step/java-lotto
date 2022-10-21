package lotto;

import java.math.BigDecimal;

import lotto.domain.Lotto;
import lotto.domain.Rank;
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

    public void startLottoWithBonus() {
        BigDecimal payAmount = inputView.inputPayAmount();
        Lotto lotto = lottoFactory.generateLotto(payAmount);
        outputView.printPurchasedLotto(lotto);

        WinningNumber winningNumber = inputView.inputWinningNumberWithBonus();
        Rank lottoRankMap = winningNumber.calcLottoRankWithBonus(lotto);
        outputView.printStatisticLottoWithBonus(lottoRankMap);

        BigDecimal prizeMoney = calculator.calculatePrizeMoney(lottoRankMap);
        outputView.printYield(calculator.calculateYield(payAmount, prizeMoney));
    }
}
