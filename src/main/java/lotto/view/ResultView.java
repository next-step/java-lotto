package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoManager;


public class ResultView {
    public static void printLottos(LottoManager lottoManager) {

        System.out.printf("%d개를 구매했습니다.", lottoManager.countPurchasedLottos());
        System.out.println();

        for (Lotto lotto : lottoManager.purchasedLottos()) {
            System.out.println(lotto);
        }

    }

}
