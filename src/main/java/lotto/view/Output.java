package lotto.view;

import lotto.domain.*;

import java.util.List;
import java.util.Map;

public class Output {

    private Output() {
    }

    public static void printBuyLottoNumber(Lotto lottoNumbers) {
        System.out.println(lottoNumbers);
    }

    public static void printLottoCount(Money money) {

        System.out.println(money.getBuyCount() + "개를 구매했습니다.");
    }

    public static void printResultStatic(WinningLottoResult lottoResult, int buyCount) {
        Map<Prize, Integer> result = lottoResult.getResult();

        for (Map.Entry<Prize, Integer> gameResult : result.entrySet()) {
            int money = gameResult.getKey().getMoney();
            System.out.println(gameResult.getKey().getDetail()  + "(" + money + "원) -" + gameResult.getValue() + "개");

        }

        float revenue = lottoResult.getRevenueStatic(buyCount);
        System.out.print("총 수익률은 " + revenue + "입니다");
        System.out.println("(기준이 1이기 때문에 결과적으로 " + lottoResult.benefitOrLoss(revenue) + " 라는 의미임)");
    }
}
