package Lotto.view;

import java.util.Arrays;
import java.util.List;

public class ResultView {
    public void printBuyNum(int num) {
        System.out.println(num + "개를 구매했습니다.");
    }

    public void printLotto(List<List<Integer>> numbers) {
        for (List<Integer> lotto : numbers) {
            System.out.println(lotto);
        }
    }

    public void printWinStatistics(List<Integer> winCount, double profitRate) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원)- " + winCount.get(0) + "개");
        System.out.println("4개 일치 (50000원)- " + winCount.get(1) + "개");
        System.out.println("5개 일치 (1500000원)- " + winCount.get(2) + "개");
        System.out.println("6개 일치 (2000000000원)- " + winCount.get(3) + "개");

        if (profitRate < 1) {
            System.out.println("총 수익률은 " + profitRate + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        } else {
            System.out.println("총 수익률은 " + profitRate + "입니다.");
        }
    }
}
