package lotto.oop.ui;

import java.util.Map;

public class ResultView {
    private int treeUnity;
    private int fourUnity;
    private int fiveUnity;
    private int sixUnity;

    public void displayIssueStats(Map<Integer, Integer> result, int amount) {
        treeUnity = result.get(3) == null ? 0 : result.get(3);
        fourUnity = result.get(4) == null ? 0 : result.get(4);
        fiveUnity = result.get(5) == null ? 0 : result.get(5);
        sixUnity = result.get(6) == null ? 0 : result.get(6);
        displayInfo(amount);

    }

    private void displayInfo(int amount) {
        System.out.println("당첨 통계");
        System.out.println("________");
        System.out.println("3개 일치 (5,000원)- " + treeUnity + "개");
        System.out.println("4개 일치 (50,000)- " + fourUnity + "개");
        System.out.println("5개 일치 (1,500,000원)- " + fiveUnity + "개");
        System.out.println("6개 일치 (2,000,000,000원)- " + sixUnity + "개");
        displayGrossReturn(amount);
    }

    private void displayGrossReturn(int amount) {
        int earnings = (5000 * treeUnity) + (50000 * fourUnity) + (1500000 * fiveUnity) + (2000000000 * sixUnity);
        double grossReturn = (((earnings / (double)amount) - 1) * 100)/100 + 1;
        if (grossReturn < 1.0) {
           System.out.println("총 수익률은 " + Math.floor((grossReturn) * 100) / 100.0 + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임");
        }
        if (grossReturn >= 1.0) {
            System.out.println("총 수익률은 " + Math.floor((grossReturn) * 100) / 100.0 + "입니다.");
        }
    }
}
