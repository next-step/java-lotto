package lotto.view;

import lotto.domain.Lotto;

public class ResultView {

    public static void printPurchaseInfo(int lottoCount) {
        System.out.println(String.format("%d개를 구매했습니다.", lottoCount));
    }

    public void printLottoNumbers(Lotto lotto) {
        System.out.println(lotto.numbers().toString());
    }
}
