package view;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ResultView {

    private final static Map<Integer, Integer> PROFIT_VALUE = new HashMap<>();
    static {
        PROFIT_VALUE.put(3, 5000);
        PROFIT_VALUE.put(4, 50000);
        PROFIT_VALUE.put(5, 1500000);
        PROFIT_VALUE.put(6, 2000000000);
    }

    public static void printWinningStatistics(Map<Integer, Integer> result){
        System.out.println("당첨 통계\n-----------");
        Iterator<Integer> keys = result.keySet().iterator();
        while (keys.hasNext()) {
            int key = keys.next();
            System.out.println(key + "개 일치 (" + PROFIT_VALUE.get(key) +
                    ")원 - " + result.get(key) + "개");
        }
    }

    public static void printProfitRate(Map<Integer, Integer> result, int inputMoney){
        double totalProfit = 0.0;

        Iterator<Integer> keys = result.keySet().iterator();
        while (keys.hasNext()) {
            int key = keys.next();
            totalProfit += (double) PROFIT_VALUE.get(key) * result.get(key);
        }

        System.out.println("총 수익률은 " + totalProfit / (double) inputMoney + "입니다.");
    }

}
