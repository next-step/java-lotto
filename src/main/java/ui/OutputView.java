package ui;

import lotto.LottoTicket;
import lotto.Rank;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.YieldCalculator.calculateYield;

public class OutputView {

    public static void printLottoTickets(List<LottoTicket> lottoTickets) {
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");
        lottoTickets.forEach(System.out::println);
        System.out.println();
    }

    public static void printResult(List<Integer> winningNumbers, int bonusNumber, List<LottoTicket> lottoTickets) {
        var result = lottoTickets.stream()
                .collect(Collectors.groupingBy(lottoTicket -> Rank.valueOf(lottoTicket.countMatches(winningNumbers), lottoTicket.hasBonusNumber(bonusNumber)), Collectors.counting()));

        System.out.println("당첨 통계");
        System.out.println("---------");

        Rank.getWiningRanks().forEach(it -> printGuideMessage(it, result.getOrDefault(it, 0L)));

        System.out.println("총 수익률은 " + calculateYield(result) + "%입니다.");
    }

    private static void printGuideMessage(Rank rank, long matchedCount) {
        if (rank == Rank.SECOND) {
            System.out.println(rank.getCountOfMatch() + "개 일치, 보너스 볼 일치 (" + rank.getWinningMoney() + "원) - " + matchedCount + "개");
            return;
        }
        System.out.println(rank.getCountOfMatch() + "개 일치 (" + rank.getWinningMoney() + "원) - " + matchedCount + "개");
    }
}
