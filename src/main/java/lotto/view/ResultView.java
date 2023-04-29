package lotto.view;

import lotto.domain.MyLotto;
import lotto.domain.WinLotto;

import java.util.List;

public class ResultView {
    public static void showMyLottos(List<MyLotto> myLottos) {
        for (MyLotto myLotto : myLottos) {
            System.out.println(myLotto);
        }
        System.out.println();
    }

    public static void showWinLotto(WinLotto winLotto) {
        System.out.printf("지난 주 당첨 번호 : %s\n", winLotto);
    }
}
