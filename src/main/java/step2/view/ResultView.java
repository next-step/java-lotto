package step2.view;

import step2.domain.Lotto;
import step2.domain.Winnings;

import java.util.List;
import java.util.Map;

public class ResultView {

    public static void showList(List<Lotto> lottoList) {
        System.out.printf("%d개를 구매했습니다.\n", lottoList.size());
        for (Lotto lotto : lottoList) {
            System.out.println(lotto);
        }
    }

    public static void showResult(Map<Integer, Integer> result, int money) {
        System.out.println("\n당첨통계");
        System.out.println("---------");
        int totalMoney = 0;
        for (int correctCount : result.keySet()) {
            System.out.printf("%d개 일치 (%d원)- %d개\n", correctCount, Winnings.find(correctCount), result.get(correctCount));
            if (result.get(correctCount) > 0) {
                totalMoney += Winnings.find(correctCount) * result.get(correctCount);
            }
        }
        System.out.printf("총 수익률은 %.2f 입니다.",calculateYield(money,totalMoney));
    }

    private static double calculateYield(int money, int totalMoney) {
        if(totalMoney != 0){
            return 1.0*totalMoney/money;
        }
        return 0;
    }
}
