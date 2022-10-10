package lotto.view;

import lotto.model.Lotto;

import java.util.List;

public class OutputView {

    public static void printLotto(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }
}
