package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.WinningLottoResult;

import java.util.Map;

public class Output {

    public void printBuyLottoNumber(Lotto lottoNumbers) {
        System.out.println(lottoNumbers.getNumbers());
    }

    public void printLottoCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public void printResultStatic(WinningLottoResult lottoResult, int buyCount) {
        Map<Prize, Integer> result = lottoResult.getResult();

        for (Map.Entry<Prize, Integer> gameResult : result.entrySet()) {
            int money = gameResult.getKey().getMoney();
            System.out.println(gameResult.getKey() + "개 일치" + "(" + money + "원) -" + gameResult.getValue() + "개");

        }

        float revenue = lottoResult.getRevenueStatic(buyCount);
        System.out.print("총 수익률은 " + revenue + "입니다");
        System.out.println("(기준이 1이기 때문에 결과적으로 " + lottoResult.benefitOrLoss(revenue) + " 라는 의미임)");
    }
}
