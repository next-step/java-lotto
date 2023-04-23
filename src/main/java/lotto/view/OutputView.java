package lotto.view;

import lotto.domain.LottoTicket;
import lotto.domain.Rank;

import java.util.HashMap;
import java.util.Map;

public class OutputView {

    private static final Map<Integer, String> MATCH_MESSAGES = new HashMap<>();

    static {
        MATCH_MESSAGES.put(3, "3개 일치(5000원)-");
        MATCH_MESSAGES.put(4, "4개 일치(50000원)-");
        MATCH_MESSAGES.put(5, "5개 일치(1500000원)-");
        MATCH_MESSAGES.put(6, "6개 일치(2000000000원)-");
    }

    public static void printLottos(LottoTicket lottoTicket) {
        lottoTicket.getLottoNumbers().forEach(System.out::println);
    }

    public static void printWinningStatistics(int purchaseAmount, LottoTicket lottoTicket) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (Integer key : MATCH_MESSAGES.keySet()) {
            System.out.println(MATCH_MESSAGES.get(key) + lottoTicket.findRankCount(key) + "개");
        }

        System.out.println("총 수익률은 " + calculateReturnRate(purchaseAmount, lottoTicket) + "입니다.");
    }

    public static Double calculateReturnRate(int purchaseAmount, LottoTicket lottoTicket) {
        double profits = 0;

        for (Integer key : MATCH_MESSAGES.keySet()) {
            profits += lottoTicket.findRankCount(key) * Rank.valueOf(key).getWinningMoney();
        }

        return profits / purchaseAmount;
    }
}
