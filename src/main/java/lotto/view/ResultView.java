package lotto.view;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ResultView {

    private ResultView() {
    }

    public static void printPurchaseLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printLottoNumbers(Map<Integer, List<Integer>> lottos) {
        for(int count = 1; count <= lottos.size(); count++) {
            List<Integer> lotto = lottos.get(count);

            Collections.sort(lotto);

            System.out.println(lotto);
        }
    }
}
