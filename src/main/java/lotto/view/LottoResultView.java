package lotto.view;

import lotto.Lotto;

import java.util.List;

public class LottoResultView {
    private LottoResultView () {

    }

    public static void printLottoCount(int count) {
        System.out.printf("%d개를 구매했습니다.\n", count);
    }

    public static void printLotto(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.toString());
        }
    }
}
