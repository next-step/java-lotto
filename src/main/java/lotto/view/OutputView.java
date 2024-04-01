package lotto.view;

import lotto.domain.*;


public class OutputView {

    public static void printCount(int manualCount, int leftOvers){
        System.out.println(String.format("수동으로 %d장, 자동으로 %d개를 구매했습니다", manualCount, leftOvers));
    }

    public static void printLottoGroup(Lottos lottos) {
        StringBuilder sb = new StringBuilder();
        for (Lotto number : lottos.getLottoNumbers()) {
            sb.append(number);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void printResult(Cash cash, Match match) {
        printMatchCache(match.getMatchCache());
        System.out.println("당첨 통계");
        System.out.println("---------");
        printProfit(match.getProfit(), cash);
    }

    private static void printMatchCache(MatchCache matchCache) {
        System.out.printf("\n3개 일치 (5000원)- %d개%n", matchCache.getCounts()[2]);
        System.out.printf("4개 일치 (50000원)- %d개%n", matchCache.getCounts()[3]);
        System.out.printf("5개 일치 (1500000원)- %d개%n", matchCache.getCounts()[4]);
        System.out.printf("5개 일치, 보너스 볼 일치(30000000원) - %d개%n", matchCache.getBonusCount());
        System.out.printf("6개 일치 (2000000000원) - %d개%n", matchCache.getCounts()[5]);
    }

    private static void printProfit(Profit profit, Cash cash) {
        System.out.printf("총 수익률은 %.2f입니다.%n", profit.calcRate(cash.getMoney()));
    }
}
