package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Prize;

import java.util.Map;

public class Output {

    public void printBuyLottoNumber(Lotto lottoNumbers) {
        System.out.println(lottoNumbers.toString());
    }

    public void printLottoCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public void printResultStatic(Map<Integer, Integer> inputResultStatic) {

        for (Map.Entry<Integer, Integer> gameResult : inputResultStatic.entrySet()) {
            int money = Prize.findByMoney(gameResult.getKey()).getMoney();
            System.out.println(gameResult.getKey() + "개 일치" + "(" + money + "원) -" + gameResult.getValue() + "개");

        }

    }

    public void printTotalRevenue(float totalRevenue, String mention) {

        System.out.print("총 수익률은 " + totalRevenue + "입니다.");
        System.out.print(" (기준이 1이기 때문에 결과적으로 " + mention + " 라는 의미임)");
    }
}
