package lotto;

import lotto.domain.*;
import lotto.view.*;

import java.util.List;

public class LottoGame {

    public static void main(String[] args) {
        InputView inputView = new RetryInputView(new DefaultInputView());
        long purchaseAmount = inputView.purchaseAmount();
        int manualQuantity = inputView.manualQuantity(purchaseAmount);

        List<Lotto> manualNumbers = inputView.manualNumbers(manualQuantity);
        Lottos lottos = new Lottos(purchaseAmount, manualNumbers);
        OutputView.purchaseHistory(lottos);

        WinNumbers winNumbers = new WinNumbers(inputView.lastWeekWinningNumbers(), inputView.bonusBall());

        WinStatistics winStatistics = new WinStatistics(lottos, winNumbers);

        OutputView.winningStatistics(winStatistics);
    }
}
