package step2;

import java.util.List;

public class ResultView {


    public static void showLottoUnitCount(int unitCount) {
        System.out.println(unitCount + "개를 구매했습니다.");
    }

    public static void showLottoUnitDetail(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }
}
