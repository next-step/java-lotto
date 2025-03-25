package lotto.view;

import lotto.domain.model.LottoTicket;
import lotto.domain.model.LottoResult;
import lotto.domain.model.Rank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {

    public void printTickets(final List<LottoTicket> tickets) {
        System.out.printf("%d개를 구매했습니다.%n", tickets.size());
        tickets.forEach(System.out::println);
    }

    public void printResult(final LottoResult result, final int purchaseAmount) {
        printHeader();
        printWinningStatistics(result);
        printYield(result, purchaseAmount);
    }

    private void printHeader() {
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    private void printWinningStatistics(final LottoResult result) {
        Map<Rank, Integer> matchCounts = result.getRankCounts();

        Arrays.stream(Rank.values())
                .filter(rank -> rank.getWinningPrize() > 0)
                .sorted(Comparator.comparingInt(Rank::getWinningPrize))
                .forEach(rank -> printRankStatistics(rank, matchCounts));
    }

    private void printRankStatistics(Rank rank, Map<Rank, Integer> matchCounts) {
        System.out.printf(
                "%d개 일치 (%d원)- %d개%n",
                rank.getMatchCriteria(),
                rank.getWinningPrize(),
                matchCounts.getOrDefault(rank, 0)
        );
    }

    private void printYield(final LottoResult result, final int purchaseAmount) {
        System.out.printf("총 수익률은 %.2f입니다.%n", result.calculateYield(purchaseAmount));
    }
}
