package com.nextstep.lotto.view;

import com.nextstep.lotto.domain.Lotto;
import com.nextstep.lotto.domain.LottoSeller;
import com.nextstep.lotto.domain.Lottos;
import com.nextstep.lotto.domain.WinningLotto;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public class LottoMain {
    public static void main(String[] args) {
        LottoMain.run();
    }

    public static void run() {
        Lottos lottos = buy();
        draw(lottos);
    }

    private static Lottos buy() {
        int totalCount = inputWithoutException(InputView::inputPriceToCount);
        int manualCount = inputWithoutException(() -> InputView.inputManualCount(totalCount));
        int autoCount = totalCount - manualCount;

        Lottos lottos = buyLottos(manualCount, autoCount);
        ResultView.printBuy(manualCount, autoCount, lottos);
        return lottos;
    }

    private static Lottos buyLottos(int manualCount, int autoCount) {
        List<Lotto> manualLottos = inputManualLottos(manualCount);
        List<Lotto> autoLottos = LottoSeller.buyAutoLottos(autoCount);
        manualLottos.addAll(autoLottos);
        return new Lottos(manualLottos);
    }

    private static List<Lotto> inputManualLottos(int manualCount) {
        List<Lotto> manualLottos = new ArrayList<>();
        for ( int i = 0 ; i < manualCount ; i ++ ) {
            Lotto manualLotto = inputWithoutException(InputView::inputManualLotto);
            manualLottos.add(manualLotto);
        }
        return manualLottos;
    }

    private static void draw(Lottos lottos) {
        WinningLotto winningLotto = inputWithoutException(InputView::inputWinningLotto);
        ResultView.printStatistics(lottos.summarizingLotto(winningLotto));
    }

    private static <T> T inputWithoutException(Supplier<T> supplier) {
        Optional<T> result;
        do {
            result = handleException(supplier);
        } while(!result.isPresent());
        return result.get();
    }

    private static <T> Optional<T> handleException(Supplier<T> supplier) {
        Optional<T> result = Optional.empty();
        try {
            result = Optional.of(supplier.get());
        } catch ( Exception e ) {
            System.out.println(e.getMessage());
        }
        return result;
    }
}
