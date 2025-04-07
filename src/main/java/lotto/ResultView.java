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
        for (int matches = 6; matches >= 0; matches--) {
            int count = statistics.getCountByMatches(matches);
            if (count > 0) {
                LottoRank prize = LottoRank.getPrize(matches);
                System.out.println(formatMatchCount(prize, count));
            }
        }
    }

    private static String formatMatchCount(LottoRank prize, int count) {
        return prize.toString() + " - " + count + "개";
    }

}
