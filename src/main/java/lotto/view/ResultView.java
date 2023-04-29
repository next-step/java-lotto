package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class ResultView {
    public static void showLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public static void showlastWinLottoInfo(Lotto lastWinLottoInfo) {
        System.out.printf("지난 주 당첨 번호 : %s\n",lastWinLottoInfo);
    }
}
