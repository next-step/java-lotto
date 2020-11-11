package lotto.view;

import lotto.asset.ResultViewConst;

public class ResultView {
    private ResultView() {}

    public static void printNumOfLottos(int numOfLottos) {
        System.out.println(numOfLottos + ResultViewConst.NUM_OF_LOTTOS_MSG);
    }
}
