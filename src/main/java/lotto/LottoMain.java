package lotto;

import java.util.List;
import lotto.domain.*;
import lotto.service.LottosBundleGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.math.BigDecimal;

import static lotto.domain.LottoStatistics.calculateStatistics;

public class LottoMain {

    public static void main(String[] args) {
        // 로또 구매
        BigDecimal amount = InputView.inputPurchaseAmount();
        LottoPurchase purchase = new LottoPurchase(amount);

        // 로또 구매 및 수동 로또 입력
        int manualCount = InputView.inputManualCount();
        List<String> manualLotto = InputView.inputManualLotto(manualCount);
        LottosBundleGenerator generator = new LottosBundleGenerator(purchase, manualLotto);
        Lottos lottos = generator.generate();

        OutputView.printLotto(lottos, manualCount);

        // 로또 당첨 번호 입력
        Lotto winningNumbers = InputView.inputWinningNumbers();
        LottoNumber bonusNumber = InputView.inputBonusNumber();
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        // 당첨 통계 및 수익률 출력
        LottoStatistics statistics = calculateStatistics(lottos, winningLotto);
        OutputView.printWinningStatistics(statistics);
        OutputView.printYield(statistics.calculateYield(amount));
    }
}
