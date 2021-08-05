package app.view;

import app.action.LottoMarket;
import app.domain.Money;
import app.domain.lotto.Lotto;
import app.domain.Winning;

import java.util.List;
import java.util.Map;

public class ResultView {

    public static void showList(List<Lotto> lottoList, Money money) {
        int randomLottoCount = money.getMoney()/ LottoMarket.PRICE;
        System.out.printf("수동으로 %d개, 자동으로 %d개를 구매했습니다.\n", lottoList.size()-(randomLottoCount), randomLottoCount);
        for (Lotto lotto : lottoList) {
            System.out.println(lotto);
        }
    }

    public static void showResult(Map<Winning, Integer> result, int money) {
        System.out.println("\n당첨통계");
        System.out.println("---------");
        int totalMoney = 0;
        for (Winning winning : result.keySet()) {
            if (winning.equals(Winning.SECOND)) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%d원)- %d개\n", winning.getMatchCount(), winning.getPrice(), result.get(winning));
            } else {
                System.out.printf("%d개 일치 (%d원)- %d개\n", winning.getMatchCount(), winning.getPrice(), result.get(winning));
            }
            if (result.get(winning) > 0) {
                totalMoney += winning.getPrice() * result.get(winning);
            }
        }
        double yield = calculateYield(money, totalMoney);
        String comment = getComment(yield);
        System.out.printf("총 수익률은 %.2f 입니다.(기준이 1이기 때문에 결과적으로 %s)", yield, comment);
    }

    private static String getComment(double yield) {
        if (yield >= 1) {
            return "이득이라는 의미임";
        }
        return "손해라는 의미임";
    }

    private static double calculateYield(int money, int totalMoney) {
        if (totalMoney != 0) {
            return 1.0 * totalMoney / money;
        }
        return 0;
    }

    public static void nothingToDo() {
        System.out.println("금액이 부족합니다. 앱을 종료합니다.");
    }
}
