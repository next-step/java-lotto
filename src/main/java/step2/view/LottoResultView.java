package step2.view;

import step2.Lotto;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoResultView {

    private static final String LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.";
    private static final String LOTTO_RESULT_MESSAGE = "%d개 일치, (%d원)- %d개";
    private static final String LOTTO_EARNED_RATE_MESSAGE = "총 수익률은 %s입니다.";

    private static final int PRICE_PER_LOTTO = 1_000;

    private static final LinkedHashMap<Integer,Integer> LOTTO_WINNING_INFO = new LinkedHashMap<>();

    static {
        LOTTO_WINNING_INFO.put(3, 5_000);
        LOTTO_WINNING_INFO.put(4, 50_000);
        LOTTO_WINNING_INFO.put(5, 1_500_000);
        LOTTO_WINNING_INFO.put(6, 2_000_000_000);
    }

    public void printPurchaseComplete(int count){
        System.out.println(String.format(LOTTO_COUNT_MESSAGE, count));
    }
    public void printList(List<Lotto> list){
        for(Lotto t: list){
            Collections.sort(t.numbers());
            System.out.println(t.numbers());
        }
    }

    public void printResult(int[] winningNumbers, List<Lotto> list){
        printResultTitle();
        double totalEarnedAmount = processResult(winningNumbers, list);
        printEarnedRate(list, totalEarnedAmount);
    }

    private static double processResult(int[] winningNumbers, List<Lotto> list) {
        double totalEarnedAmount = 0;
        LinkedHashMap<Integer, Integer> result = new LinkedHashMap<>();
        for(Map.Entry<Integer, Integer> entry: LOTTO_WINNING_INFO.entrySet()){
            int key = entry.getKey();
            for(Lotto t: list){
                int matchCount = 0;
                for(int winningNumber : winningNumbers){
                    if(t.numbers().contains(winningNumber)){
                        matchCount++;
                    }
                }
                if(matchCount == key){
                    result.put(key, result.getOrDefault(key, 0) + 1);
                }
            }
            System.out.println(
                    String.format(LOTTO_RESULT_MESSAGE, key, entry.getValue(), result.getOrDefault(key,0))
            );
            totalEarnedAmount += result.getOrDefault(key,0) * LOTTO_WINNING_INFO.get(key);
        }
        return totalEarnedAmount;
    }

    private static void printResultTitle() {
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    private static void printEarnedRate(List<Lotto> list, double totalEarnedAmount) {
        DecimalFormat df = new DecimalFormat("#.##");
        String format = df.format(totalEarnedAmount / (PRICE_PER_LOTTO * list.size()));
        System.out.println(String.format(LOTTO_EARNED_RATE_MESSAGE, format));
    }
}
