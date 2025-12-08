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
        Lottos lotto = generateLotto(amount);
        OutputView.printLotto(lotto);

        // 로또 당첨 번호 입력
        Lotto winningLotto = InputView.inputWinningNumbers();

        // 당첨 통계 및 수익률 출력
        LottoStatistics statistics = calculateStatistics(lotto, winningLotto);
        OutputView.printWinningStatistics(statistics);
        OutputView.printYield(statistics.calculateYield(amount));
    }
}
