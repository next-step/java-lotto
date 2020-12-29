package lotto.oop.ui;

import java.util.Map;

public class ResultView {
    private int first;
    private int second;
    private int third;
    private int fourth;
    private int fifth;

    public void displayIssueStats(Map<Integer, Integer> result, int amount) {
        first = result.get(1) == null ? 0 : result.get(1);
        second = result.get(2) == null ? 0 : result.get(2);
        third = result.get(3) == null ? 0 : result.get(3);
        fourth = result.get(4) == null ? 0 : result.get(4);
        fifth = result.get(5) == null ? 0 : result.get(5);
        displayInfo(amount);
    }

    private void displayInfo(int amount) {
        System.out.println("당첨 통계");
        System.out.println("________");
        System.out.println("3개 일치 (5,000원)- " + fifth + "개");
        System.out.println("4개 일치 (50,000)- " + fourth + "개");
        System.out.println("5개 일치 (1,500,000원)- " + third + "개");
        System.out.println("5개 일치, 보너스 볼 일치(30,000,000원)- " + second + "개");
        System.out.println("6개 일치 (2,000,000,000원)- " + first + "개");
        displayGrossReturn(amount);
    }

    private void displayGrossReturn(int amount) {
        int earnings = (5000 * fifth) + (50000 * fourth) + (1500000 * third) + (30000000 * second) + (2000000000 * first);
        double grossReturn = (((earnings / (double)amount) - 1) * 100)/100 + 1;
        if (grossReturn < 1.0) {
           System.out.println("총 수익률은 " + Math.floor((grossReturn) * 100) / 100.0 + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임");
        }
        if (grossReturn >= 1.0) {
            System.out.println("총 수익률은 " + Math.floor((grossReturn) * 100) / 100.0 + "입니다.");
        }
    }
}
