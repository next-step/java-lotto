package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Revenue;

import java.util.List;

public class Output {

    private Output() {
    }

    public static void printBuyLottoNumber(List<Lotto> lottoNumbers) {
        for (Lotto lotto : lottoNumbers) {
            System.out.println(lotto);
        }
    }

    public static void printResultWinningStatic(List<String> lottoResult) {
        for (String result : lottoResult) {
            System.out.println(result);
        }
    }

    public static void printResultRevenu(Revenue revenueRate) {

        System.out.print("총 수익률은 " + revenueRate.getRevenueStatic() + "입니다");
        System.out.println("(기준이 1이기 때문에 결과적으로 " + revenueRate.benefitOrLoss() + " 라는 의미임)");
    }

    public static void printAutoCountSelectCount(int autoGameCount, int selectGameCount) {
        System.out.print("수동으로 " + selectGameCount + "장, ");
        System.out.println("자동으로 " + autoGameCount + "개를 구매핬습니다.");
    }
}
