package lotto;

import lotto.domain.*;
import lotto.view.*;

import java.util.List;

public class LottoGame {

    public static void main(String[] args) {
        InputViewV2 inputViewV2 = new RetryInputView(new DefaultInputViewV2());
        long purchaseAmount = inputViewV2.purchaseAmount();
        int manualQuantity = inputViewV2.manualQuantity(purchaseAmount);

        List<Lotto> manualNumbers = inputViewV2.manualNumbers(manualQuantity);
        Lottos lottos = new Lottos(purchaseAmount, manualNumbers);
        OutputView.purchaseHistory(lottos);

        WinNumbers winNumbers = new WinNumbers(inputViewV2.lastWeekWinningNumbers(), inputViewV2.bonusBall());

        WinStatistics winStatistics = new WinStatistics(lottos, winNumbers);

        OutputView.winningStatistics(winStatistics);
    }
}
