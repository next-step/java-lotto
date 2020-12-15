package com.nextstep.lotto.view;

import com.nextstep.lotto.domain.Lotto;
import com.nextstep.lotto.domain.LottoSeller;
import com.nextstep.lotto.domain.Lottos;

import java.util.ArrayList;
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
        int price = inputWithoutException(InputView::inputPrice);
        int totalCount = LottoSeller.count(price);
        int manualCount = inputWithoutException(() -> InputView.inputManualCount(totalCount));
        int autoCount = totalCount - manualCount;

        List<Lotto> manualLottos = inputManualLottos(manualCount);
        Lottos lottos = LottoSeller.buy(manualLottos, autoCount);
        ResultView.printBuy(manualCount, autoCount, lottos);
        return lottos;
    }

    private static List<Lotto> inputManualLottos(int manualCount) {
        List<Lotto> manualLottos = new ArrayList<>();
        for ( int i = 0 ; i < manualCount ; i ++ ) {
            Lotto manualLotto = inputWithoutException(InputView::inputManualLottos);
            manualLottos.add(manualLotto);
        }
        return manualLottos;
    }

    private static void draw(Lottos lottos) {
        List<Integer> winnerNumbers = inputWithoutException(InputView::inputWinnerNumbers);
        int bonusNumber = inputWithoutException(InputView::inputBonusNumber);
        ResultView.printStatistics(lottos.getStatistics(winnerNumbers, bonusNumber));
    }

    public static <T> T inputWithoutException(Supplier<T> supplier) {
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
