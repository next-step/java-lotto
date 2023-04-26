package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoGame {

    public static void main(String[] args) {
        long purchaseAmount = InputView.purchaseAmount();
        int manualQuantity = InputView.manualQuantity();

        List<Lotto> manualNumbers = InputView.manualNumbers(manualQuantity);
        Lottos lottos = new Lottos(purchaseAmount, manualNumbers);
        OutputView.purchaseHistory(lottos);

        WinNumbers winNumbers = new WinNumbers(InputView.lastWeekWinningNumbers(), InputView.bonusBall());

        WinStatistics winStatistics = new WinStatistics(lottos, winNumbers);

        OutputView.winningStatistics(winStatistics);
    }
}
