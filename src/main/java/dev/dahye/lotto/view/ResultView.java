package dev.dahye.lotto.view;

import dev.dahye.lotto.domain.LottoResult;
import dev.dahye.lotto.domain.LottoTicket;
import dev.dahye.lotto.domain.Rank;

import java.util.List;

public class ResultView {
    public static void printPurchasedLottoTickets(List<LottoTicket> lottoTickets) {
        System.out.println(lottoTickets.size() + "개를 구입했습니다.");
        for (LottoTicket lottoTicket : lottoTickets) {
            System.out.println(lottoTicket.toString());
        }
    }

    public static void printWinningStatistics(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (Rank rank : Rank.values()) {
            System.out.println(rank.getCountOfMatch() + "개 일치 (" + rank.getPrize() + "원) - "
                    + lottoResult.getTotalCountWhenSpecificWinning(rank) + "개");
        }
    }

    public static void printWinningRate(double number) {
        System.out.println("총 수익률은 " + number + "입니다.");
    }
}
