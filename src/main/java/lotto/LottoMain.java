package lotto;

import lotto.domain.*;
import lotto.service.LottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.math.BigDecimal;

import static lotto.domain.LottoStatistics.calculateStatistics;

public class LottoMain {

    public static void main(String[] args) {
        // 로또 구매
        BigDecimal amount = InputView.inputPurchaseAmount();

        // 수동 로또 구매
        int manualCount = InputView.inputManualCount();
        Lottos manualLotto = InputView.inputManualLotto(manualCount);

        // 수동 + 자동 로또 구매
        Lottos purchasedLotto = LottoGenerator.generate(amount, manualLotto);
        OutputView.printLotto(purchasedLotto, manualCount);

        // 로또 당첨 번호 입력
        Lotto winningNumbers = InputView.inputWinningNumbers();
        LottoNumber bonusNumber = InputView.inputBonusNumber();
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        // 당첨 통계 및 수익률 출력
        LottoStatistics statistics = calculateStatistics(purchasedLotto, winningLotto);
        OutputView.printWinningStatistics(statistics);
        OutputView.printYield(statistics.calculateYield(amount));
    }
}
