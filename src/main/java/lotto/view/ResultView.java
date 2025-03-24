package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class ResultView {
    public static void printLottos(List<Lotto> lottos) {
        System.out.printf("%s개를 구매했습니다.\n", lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
        System.out.println();
    }
}
