package lotto.lottoView;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Money;
import lotto.domain.Rank;

import java.util.List;


public class ResultView {

    public static void printTotalCount(int totalCount, int manualCount) {
        System.out.println("수동으로 " + manualCount + "장, 자동으로 " + (totalCount - manualCount) + "개를 구매했습니다.");
    }

    public static void printAllLotteries(List<Lotto> lotteries) {
        for (Lotto lotto : lotteries) {
            makeString(lotto);
        }
    }

    public static void makeString(Lotto lotto) {
        String numberList = "";
        numberList += "[";
        numberList += lotto.toString(", ");
        numberList += "]";

        System.out.println(numberList);
    }

    public static void makeStatistic(LottoResult result) {
        System.out.println("3개 일치 (5000원) - " + result.get(Rank.FIFTH) + "개");
        System.out.println("4개 일치 (50000원) - " + result.get(Rank.FOURTH) + "개");
        System.out.println("5개 일치 (1500000원) - " + result.get(Rank.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치(30000000원) - " + result.get(Rank.SECOND) + "개");
        System.out.println("6개 일치 (2000000000원) - " + result.get(Rank.FIRST) + "개");

    }

    public static void winRate(LottoResult result, Money money) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        makeStatistic(result);
        System.out.println("총 수익률은 " + money.calculateRate(result.getTotalSum()) + "입니다.");
    }
}
