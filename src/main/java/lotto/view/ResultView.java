package lotto.view;

import lotto.asset.ResultViewConst;
import lotto.domain.Lottos;

public class ResultView {
    private ResultView() {}

    public static void printNumOfLottos(int numOfLottos) {
        System.out.println(numOfLottos + ResultViewConst.NUM_OF_LOTTOS_MSG);
    }

    public static void printLottos(Lottos lottos) {
        System.out.println(lottos);
    }
}
