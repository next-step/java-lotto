package com.nextstep.lotto.view;

import com.nextstep.lotto.domain.Lotto;
import com.nextstep.lotto.domain.LottoSeller;
import com.nextstep.lotto.domain.Lottos;

import java.util.List;

public class LottoMain {
    public static void main(String[] args) {
        LottoMain.run();
    }

    public static void run() {
        Lottos lottos = buy();
        draw(lottos);
    }

    private static Lottos buy() {
        int price = InputView.inputPrice();
        int totalCount = LottoSeller.count(price);
        int manualCount = InputView.inputManualCount();
        int autoCount = totalCount - manualCount;
        List<Lotto> manualLottos = InputView.inputManualLottos(manualCount);
        Lottos lottos = LottoSeller.buy(autoCount);
        lottos.addAll(manualLottos);
        ResultView.printBuy(manualCount, autoCount, lottos);
        return lottos;
    }

    private static void draw(Lottos lottos) {
        List<Integer> winnerNumbers = InputView.inputWinnerNumbers();
        int bonusNumber = InputView.inputBonusNumber();
        ResultView.printStatistics(lottos.getStatistics(winnerNumbers, bonusNumber));
    }
}
