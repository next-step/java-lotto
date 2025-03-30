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
        System.out.println(Rank.FIFTH.guideMessage(result.getOrDefault(Rank.FIFTH, 0L)));
        System.out.println(Rank.FOURTH.guideMessage(result.getOrDefault(Rank.FOURTH, 0L)));
        System.out.println(Rank.THIRD.guideMessage(result.getOrDefault(Rank.THIRD, 0L)));
        System.out.println(Rank.SECOND.guideMessage(result.getOrDefault(Rank.SECOND, 0L)));
        System.out.println(Rank.FIRST.guideMessage(result.getOrDefault(Rank.FIRST, 0L)));

        System.out.println("총 수익률은 " + calculateYield(result) + "%입니다.");
    }
}
