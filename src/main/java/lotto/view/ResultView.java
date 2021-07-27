package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class ResultView {

    public static void printPurchasedLottos(List<Lotto> purchasedLottos) {
        System.out.println(purchasedLottos.size() + "개를 구매했습니다.");
        purchasedLottos.forEach(lotto -> System.out.println(lotto.getValues()));
    }
}
