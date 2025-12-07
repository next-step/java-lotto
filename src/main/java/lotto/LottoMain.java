package lotto;

import lotto.view.InputView;
import lotto.view.OutputView;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static lotto.LottoGenerator.generateLotto;
import static lotto.LottoStatistics.calculateStatistics;
import static lotto.LottoStatistics.calculateYield;

public class LottoMain {

    public static void main(String[] args) {
        // 로또 구매
        BigDecimal amount = InputView.inputPurchaseAmount();
        List<Lotto> lotto = generateLotto(amount);
        OutputView.printLotto(lotto);

        // 로또 당첨 번호 입력
        Lotto winningLotto = InputView.inputWinningNumbers();

        // 당첨 통계 및 수익률 출력
        Map<LottoRank, Integer> statistics = calculateStatistics(lotto, winningLotto);
        OutputView.printWinningStatistics(statistics);
        OutputView.printYield(calculateYield(statistics, amount));
    }
}
