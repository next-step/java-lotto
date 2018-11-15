package lotto.view;

import lotto.Lotto;
import lotto.LottoComparator;

import java.util.List;

public class OutputView {
    public static void printAmount(int quantity) {
        System.out.println(quantity + "개를 구매했습니다.");
    }

    public static void printPurchaseLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
        System.out.println();
    }

    public static void printCompareResult(LottoComparator lottoComparator) {
        System.out.println();
        System.out.println("당첨통계");
        System.out.println("---------");
        System.out.println(lottoComparator);
    }

    public static void printEaningRate(double earningRate) {
        System.out.println("총 수익률은" + earningRate + "입니다.");
    }
}
