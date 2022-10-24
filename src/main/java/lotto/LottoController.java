package lotto;

import java.math.BigDecimal;
import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Rank;
import lotto.domain.WinningNumber;
import lotto.service.LottoFactory;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoFactory lottoFactory;

    public LottoController(InputView inputView, OutputView outputView, LottoFactory lottoFactory) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoFactory = lottoFactory;
    }

    public void startLottoWithBonus() {
        BigDecimal payAmount = inputView.inputPayAmount();

        int manualCount = inputView.inputManualCount();
        List<LottoNumber> manualNumbers = inputView.inputManualNumber(manualCount);
        Lotto lotto = lottoFactory.generateLotto(payAmount, manualNumbers);
        outputView.printPurchasedLotto(lotto, manualCount);

        WinningNumber winningNumber = inputView.inputWinningNumberWithBonus();
        Rank lottoRankMap = winningNumber.calcLottoRankWithBonus(lotto);
        outputView.printStatisticLottoWithBonus(lottoRankMap);

        outputView.printYield(lottoRankMap.calculateYield(payAmount));
    }
}
