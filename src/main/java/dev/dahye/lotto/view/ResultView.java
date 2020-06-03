package dev.dahye.lotto.view;

import dev.dahye.lotto.domain.LottoTicket;
import dev.dahye.lotto.domain.Winning;

import java.util.List;

public class ResultView {
    public static void printPurchasedLottoTickets(List<LottoTicket> lottoTickets) {
        System.out.println(lottoTickets.size() + "개를 구입했습니다.");
        for (LottoTicket lottoTicket : lottoTickets) {
            System.out.println(lottoTicket.toString());
        }
    }

    public static void printWinningStatistics(List<Winning> winnings) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (Winning winning : Winning.values()) {
            int count = getCountWhenSpecificWinning(winnings, winning);
            System.out.println(winning.getMatchCount() + "개 일치 (" + winning.getPrize() + "원) - " + count + "개");
        }
    }

    private static int getCountWhenSpecificWinning(List<Winning> winnings, Winning target) {
        int count = 0;

        for (Winning winning : winnings) {
            count = plusCountWhenEquals(target, count, winning);
        }

        return count;
    }

    private static int plusCountWhenEquals(Winning target, int count, Winning winning) {
        if (winning.equals(target)) {
            count++;
        }
        return count;
    }

    public static void printWinningRate(double number) {
        System.out.println("총 수익률은 " + number + "입니다.");
    }
}
