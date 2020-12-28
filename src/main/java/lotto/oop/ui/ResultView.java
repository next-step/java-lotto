package lotto.oop.ui;

import java.util.ArrayList;
import java.util.Map;
import java.util.Queue;

public class ResultView {
    private Map<Integer, Integer> result;
    private int amount;

    public ResultView(Map<Integer, Integer> result, int amount) {
        this.result = result;
        this.amount = amount;
    }

    public void displayIssueStats() {
        int tree = result.get(3) == null ? 0 : result.get(3);
        int four = result.get(4) == null ? 0 : result.get(4);
        int five = result.get(5) == null ? 0 : result.get(5);
        int six = result.get(6) == null ? 0 : result.get(6);
        displayInfo(tree, four, five, six);

    }

    private void displayInfo(int tree, int four, int five, int six) {
        System.out.println("당첨 통계");
        System.out.println("________");
        System.out.println("3개 일치 (5,000원)- " + tree + "개");
        System.out.println("4개 일치 (50,000)- " + four + "개");
        System.out.println("5개 일치 (1,500,000원)- " + five + "개");
        System.out.println("6개 일치 (2,000,000,000원)- " + six + "개");
        displayGrossReturn(tree, four, five, six);
    }

    private void displayGrossReturn(int tree, int four, int five, int six) {
        int earnings = (5000 * tree) + (50000 * four) + (1500000 * five) + (2000000000 * six);
        double grossReturn = (((earnings / (double)amount) - 1) * 100)/100 + 1;
        if (grossReturn < 1.0) {
//            System.out.println("총 수익률은 " + grossReturn + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임");
            System.out.printf("총 수익률은 %.2f 입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임", grossReturn);
        }
        if (grossReturn >= 1.0) {
            System.out.printf("총 수익률은 %.2f 입니다.", grossReturn);
        }
    }
}
