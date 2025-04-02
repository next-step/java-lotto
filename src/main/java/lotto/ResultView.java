package lotto;

import java.util.List;
import java.util.Map;

public class ResultView {

    public static void printCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printLottoNumber(List<LottoRow> lottoRowList) {
        for (LottoRow lottoRow : lottoRowList) {
            System.out.println(lottoRow.getLottoNumbers());
        }
    }

    public static void printWinning(Map<Prize, Integer> winning, int totalPrice) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        int totalProfit = 0;

        for (Prize prize : Prize.values()) {
            if (prize == Prize.NONE) continue;

            int count = winning.getOrDefault(prize, 0);
            totalProfit += prize.getMoney() * count;

            if (prize == Prize.SECOND) {
                System.out.println("5개 일치, 보너스 볼 일치(" + prize.getMoney() + "원) - " + count + "개");
            } else {
                System.out.println(prize.getCount() + "개 일치 (" + prize.getMoney() + "원) - " + count + "개");
            }
        }

        double rate = totalPrice == 0 ? 0.0 : (double) totalProfit / totalPrice;
        System.out.printf("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)%n",
            rate,
            rate < 1 ? "손해" : "이익"
        );
    }
}
