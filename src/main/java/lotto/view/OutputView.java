package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class OutputView {

    public static void outputLottoQuantity(Lottos lottos) {
        System.out.println("\n수동으로 " + lottos.manualLottoQuantity() + "장, 자동으로 " + lottos.autoLottoQuantity() + "개를 구매했습니다.");
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getLotto());
        }
    }
}
