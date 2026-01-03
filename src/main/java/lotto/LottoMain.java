package lotto;

import lotto.view.InputView;
import lotto.view.OutputView;

import java.math.BigDecimal;

import static lotto.LottoGenerator.generateLotto;
import static lotto.LottoStatistics.calculateStatistics;

public class LottoMain {

    public static void main(String[] args) {
        // 로또 구매
        BigDecimal amount = InputView.inputPurchaseAmount();
        Lottos purchasedLottos = generateLotto(amount);
        OutputView.printLotto(purchasedLottos);

        // 로또 당첨 번호 입력
        Lotto winningNumbers = InputView.inputWinningNumbers();
        LottoNumber bonusNumber = InputView.inputBonusNumber();
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        // 당첨 통계 및 수익률 출력
        LottoStatistics statistics = calculateStatistics(purchasedLottos, winningLotto);
        OutputView.printWinningStatistics(statistics);
        OutputView.printYield(statistics.calculateYield(amount));
    }
}
