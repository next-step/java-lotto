package me.daeho.lotto.view;

import me.daeho.lotto.domain.LottoTicket;
import me.daeho.lotto.domain.Rank;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ResultView {
    public static void ticketList(List<LottoTicket> lottoTickets) {
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");
        for (LottoTicket lottoTicket : lottoTickets) {
            System.out.println("[" + lottoTicket + "]");
        }
    }

    public static void statistics(Map<Rank, Integer> rankCounts, double earningRate) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        Arrays.stream(Rank.values())
                .filter(rank -> Rank.NONE != rank)
                .forEach(rank ->
                            System.out.println(rank.getCount() + "개 일치"
                                    + bonusBallMatchText(rank)
                                    + " (" + rank.getPrize() + "원)- "
                                    + rankCounts.getOrDefault(rank, 0) + "개")
                );
        System.out.print("총 수익률은 " + earningRate + "입니다.");
        System.out.println("(기준이 1이기 때문에 결과적으로 " + getResult(earningRate) + "라는 의미임)");
    }

    private static String bonusBallMatchText(Rank rank) {
        if(rank.isMatchBonus())
            return ", 보너스 볼 일치";

        return "";
    }

    private static String getResult(double earningRate) {
        if(earningRate < 1)
            return "손해";

        return "이득";
    }
}
