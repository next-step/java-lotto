package lotto.view;

import java.util.List;

public class ResultView {

    private ResultView() {
    }

    public static void printPurchaseLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printLottoNumbers(List<Integer>[] lottos) {
        for(List<Integer> lotto : lottos) {
            System.out.println(lotto);
        }
    }
}
