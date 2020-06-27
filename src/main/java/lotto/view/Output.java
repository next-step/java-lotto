package lotto.view;

import lotto.domain.*;

import java.util.List;
import java.util.Map;

public class Output {

    private Output() {
    }

    public static void printBuyLottoNumber(List<Lotto> lottoNumbers) {
        for (Lotto lotto : lottoNumbers) {
            System.out.println(lotto);
        }
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

    public static void printAutoCountSelectCount(LottoGame lottoGame) {
        System.out.print("수동으로 " + lottoGame.getSelectGame() + "장, ");
        System.out.println("자동으로 " + lottoGame.getAutoGame() + "개를 구매핬습니다.");
    }
}
