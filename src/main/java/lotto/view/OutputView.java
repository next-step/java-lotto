package lotto.view;

import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.Rank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutputView {

    private static final Map<Integer, List<String>> MATCH_MESSAGES = new HashMap<>();

    static {
        MATCH_MESSAGES.put(3, new ArrayList<>());
        MATCH_MESSAGES.get(3).add("3개 일치(5000원)-");

        MATCH_MESSAGES.put(4, new ArrayList<>());
        MATCH_MESSAGES.get(4).add("4개 일치(50000원)-");

        MATCH_MESSAGES.put(5, new ArrayList<>());
        MATCH_MESSAGES.get(5).add("5개 일치(1500000원)-");
        MATCH_MESSAGES.get(5).add("5개 일치, 보너스 볼 일치(30000000원)-");

        MATCH_MESSAGES.put(6, new ArrayList<>());
        MATCH_MESSAGES.get(6).add("6개 일치(2000000000원)-");
    }

    public static void printLottos(LottoTicket lottoTicket) {
        lottoTicket.getLottoNumbers().forEach(System.out::println);
    }

    public static void printWinningStatistics(int purchaseAmount, LottoResult lottoResult) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (Integer key : MATCH_MESSAGES.keySet()) {
            printMatchMessage(key, lottoResult);
        }

        System.out.println("총 수익률은 " + calculateReturnRate(purchaseAmount, lottoResult) + "입니다.");
    }

    private static void printMatchMessage(Integer key, LottoResult lottoResult) {
        List<String> messages = MATCH_MESSAGES.get(key);

        for (String message : messages) {
            System.out.println(message + lottoResult.findRankCount(key) + "개");
        }
    }

    public static Double calculateReturnRate(int purchaseAmount, LottoResult lottoResult) {
        double profits = 0;

        for (Integer key : MATCH_MESSAGES.keySet()) {
            profits += lottoResult.findRankCount(key) * Rank.valueOf(key).getWinningMoney();
        }

        return profits / purchaseAmount;
    }
}
