package autolotto.ui;

import java.util.List;

public class OutputView {
    public static void printLottoNumber(List<List<Integer>> tickets){
        tickets.forEach(System.out::println);
    }

    public static void printStatistics(int[] matchCounts){
        System.out.println("\n당첨 통계\n---------");
        System.out.println("3개 일치 (5000원)- " + matchCounts[3] + "개");
        System.out.println("4개 일치 (50000원)- " + matchCounts[4] + "개");
        System.out.println("5개 일치 (1500000원)- " + matchCounts[5] + "개");
        System.out.println("6개 일치 (2000000000원)- " + matchCounts[6] + "개");
    }
}
