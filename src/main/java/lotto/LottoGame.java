package lotto;

import lotto.domain.Lottos;
import lotto.domain.WinNumbers;
import lotto.domain.WinStatistics;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {

    public static void main(String[] args) {
        Lottos lottos = new Lottos(InputView.purchaseAmount());
        OutputView.purchaseHistory(lottos);

        WinNumbers winNumbers = new WinNumbers(InputView.lastWeekWinningNumbers());

        WinStatistics winStatistics = new WinStatistics(lottos, winNumbers);

        OutputView.winningStatistics(winStatistics);
    }
}
