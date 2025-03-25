package lotto.view;

import lotto.Lotto;
import lotto.LottoResult;

public class Outputview {
    public static void printPurchasedAmount(int amount) {
        System.out.printf("%d개를 구매했습니다.\n", amount);
    }

    public static void printLotto(Lotto lotto) {
        System.out.println(lotto);
    }

    public static void printResult(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(lottoResult);
    }
}
