package lotto.view;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import lotto.domain.Lotto;
import lotto.domain.Rank;

public class ResultView {

    private static final String TOTAL_COUNT= "개를 구매했습니다.";

    public static void printTotalCount(int value) {
        System.out.println(value + TOTAL_COUNT);
    }

    public static void printResultTickets(List<Lotto> lottoTickets) {
        for (Lotto lottoTicket : lottoTickets) {
            System.out.println(lottoTicket);
        }
    }

    public static void printStatistics(Map<Rank, Integer> result) {
        System.out.println("당첨 통계");
        System.out.println("-------");
        result.forEach((key, value) -> {
            if (key.match != Rank.NONE.match) {
                System.out.println(key.match +"개 일치"+ printBonus(key) + " (" + key.money + "원) - " + value + "개");
            }
        });
    }

    private static String printBonus(Rank rank) {
        if (rank == Rank.SECOND) {
            return ", 보너스볼 일치 ";
        }
        return "";
    }
    public static void printRating(Map<Rank, Integer> result, int total) {
        double totalWinningMoney = 0;
        for (Entry<Rank, Integer> entry : result.entrySet()) {
            Rank key = entry.getKey();
            Integer value = entry.getValue();
            totalWinningMoney += key.money.getMoney() * value;
        }
        double rate = totalWinningMoney / total;
        System.out.println("총 수익율은 " + String.format("%.2f",rate) + "입니다.");
    }
}
