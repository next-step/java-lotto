package lotto.view;

import lotto.domain.*;


public class OutputView {

    public static void printCount(int manualCount, int leftOvers){
        printPlainMessage(String.format("수동으로 %d장, 자동으로 %d개를 구매했습니다", manualCount, leftOvers));
    }

    public static void printLottoGroup(Lottos lottos) {
        StringBuilder sb = new StringBuilder();
        for (Lotto number : lottos.getLottoNumbers()) {
            sb.append(number);
            sb.append("\n");
        }
        printPlainMessage(sb.toString());
    }

    public static void printResult(Cash cash, Match match) {
        printMatchCache(match.getMatchCache());
        printPlainMessage("당첨 통계");
        printPlainMessage("---------");
        printProfit(match.getProfit(), cash);
    }

    public static void printPlainMessage(String message) {
        System.out.println(message);
    }

    private static void printMatchCache(MatchCache matchCache) {
        printPlainMessage(String.format("\n3개 일치 (5000원)- %d개", matchCache.getCounts()[2]));
        printPlainMessage(String.format("4개 일치 (50000원)- %d개", matchCache.getCounts()[3]));
        printPlainMessage(String.format("5개 일치 (1500000원)- %d개", matchCache.getCounts()[4]));
        printPlainMessage(String.format("5개 일치, 보너스 볼 일치(30000000원) - %d개", matchCache.getBonusCount()));
        printPlainMessage(String.format("6개 일치 (2000000000원) - %d개", matchCache.getCounts()[5]));
    }

    private static void printProfit(Profit profit, Cash cash) {
        printPlainMessage(String.format("총 수익률은 %.2f입니다.", profit.calcRate(cash.getAmount())));
    }
}
