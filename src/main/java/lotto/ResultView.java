package lotto;

public class ResultView {

    public static void showPurchaseResult(LottoTicket[] lottoTickets) {
        System.out.println(lottoTickets.length + "개를 구매했습니다.");
        for (LottoTicket lottoTicket : lottoTickets) {
            System.out.println(lottoTicket.toString());
        }
    }

    public static void showStatistics(LottoStatistics statistics) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        showMatchCounts(statistics);
        System.out.println("총 수익률은 " + statistics.calculateProfitRate() + "입니다.");
    }

    private static void showMatchCounts(LottoStatistics statistics) {
        for (LottoRank rank : LottoRank.values()) {
            int count = statistics.getCountByRank(rank);
            System.out.println(formatMatchCount(rank, count));
        }
    }

    private static String formatMatchCount(LottoRank rank, int count) {
        String bonusMsg = rank.isContainsBonusNumber() ? ", 보너스 볼 일치" : "";
        return String.format("%d개 일치%s (%d원) - %d개", rank.getMatchCount(), bonusMsg, rank.getPrizeMoney(1), count);
    }

}
