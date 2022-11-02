package com.nextlevel.kky.lotto;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public static void printBoughtLotto(List<List<Integer>> lottoList) {
        System.out.println(lottoList.size() + "개 구매하였습니다");
        for (List<Integer> lotto : lottoList) {
            List<String> lottoString = lotto.stream().map(Object::toString).collect(Collectors.toList());
            System.out.println("[" + String.join(",", lottoString) + "]");
        }
    }

    public static void printWinningStatistics(WinningStatistics winningStatistics) {
        System.out.println("당첨 통계");
        System.out.println("-".repeat(10));
        System.out.println("3개 일치 (5000원)-" + winningStatistics.getFourth() + "개");
        System.out.println("4개 일치 (50000원)-" + winningStatistics.getThird() + "개");
        System.out.println("5개 일치 (1500000원)-" + winningStatistics.getSecond() + "개");
        System.out.println("6개 일치 (2000000000원)-" + winningStatistics.getFirst() + "개");
        System.out.println("총 수익률은 " + winningStatistics.getAdvantageRate() + " 입니다.");
    }
}
