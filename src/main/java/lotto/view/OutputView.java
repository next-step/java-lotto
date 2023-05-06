package lotto.view;

import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.Rank;

import java.util.LinkedHashMap;
import java.util.Map;

public class OutputView {

    private static final Map<Rank, String> MATCH_MESSAGES = new LinkedHashMap<>();

    static {
        MATCH_MESSAGES.put(Rank.FIFTH, "3개 일치(5000원)-");
        MATCH_MESSAGES.put(Rank.FOURTH, "4개 일치(50000원)-");
        MATCH_MESSAGES.put(Rank.THIRD, "5개 일치(1500000원)-");
        MATCH_MESSAGES.put(Rank.SECOND, "5개 일치, 보너스 볼 일치(30000000원)-");
        MATCH_MESSAGES.put(Rank.FIRST, "6개 일치(2000000000원)-");
    }

    public static void printLottos(LottoTicket lottoTicket) {
        lottoTicket.getLottoNumbers().forEach(System.out::println);
    }

    public static void printWinningStatistics(int purchaseAmount, LottoResult lottoResult) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (Rank rank : MATCH_MESSAGES.keySet()) {
            printMatchMessage(rank, lottoResult);
        }

        System.out.println("총 수익률은 " + calculateReturnRate(purchaseAmount, lottoResult) + "입니다.");
    }

    public static Double calculateReturnRate(int purchaseAmount, LottoResult lottoResult) {
        double profits = 0;

        for (Rank rank : MATCH_MESSAGES.keySet()) {
            profits += lottoResult.findRankCount(rank.getCountOfMatch(), rank == Rank.SECOND) * rank.getWinningMoney();
        }

        return Math.round(profits / purchaseAmount * 100) / 100.0;
    }

    private static void printMatchMessage(Rank rank, LottoResult lottoResult) {
        String message = MATCH_MESSAGES.get(rank);
        System.out.println(message + lottoResult.findRankCount(rank.getCountOfMatch(), rank == Rank.SECOND) + "개");
    }

}
