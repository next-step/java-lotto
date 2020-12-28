package lotto.ui;

import java.util.HashMap;

public class resultView {
    private HashMap<Integer, Integer> stats;

    public resultView(HashMap<Integer, Integer> stats) {
        this.stats = stats;
    }

    public void displayStatsInfo() {
        int three = stats.get(3) == null ? 0 : stats.get(3);
        int four = stats.get(4) == null ? 0 : stats.get(4);
        int five = stats.get(5) == null ? 0 : stats.get(5);
        int six = stats.get(6) == null ? 0 : stats.get(6);

        System.out.println("당첨 통계");
        System.out.println("________");
        System.out.println("3개 일치 (5,000원)- " + three + "개");
        System.out.println("4개 일치 (50,000)- " + four + "개");
        System.out.println("5개 일치 (1,500,000원)- " + five + "개");
        System.out.println("6개 일치 (2,000,000,000원)- " + six + "개");

    }
}
