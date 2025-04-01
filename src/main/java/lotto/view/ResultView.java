package lotto.view;

import lotto.domain.model.game.LottoGameResult;
import lotto.domain.model.lotto.PurchaseAmount;
import lotto.domain.model.lotto.LottoTicket;
import lotto.domain.model.game.Rank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class ResultView {

    public void printTickets(final List<LottoTicket> tickets) {
        System.out.printf("%d개를 구매했습니다.%n", tickets.size());
        tickets.forEach(System.out::println);
    }

    public void printResult(final PurchaseAmount purchaseAmount, final LottoGameResult result) {
        printHeader();
        printWinningStatistics(result);
        printYield(purchaseAmount, result);
    }

    private void printHeader() {
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    private void printWinningStatistics(final LottoGameResult result) {
        Map<Rank, Integer> matchCounts = result.getRankCountMap();

        Arrays.stream(Rank.values())
                .filter(rank -> rank.getWinningPrize().getAmount() > 0)
                .sorted(Comparator.comparingInt(rank -> rank.getWinningPrize().getAmount()))
                .forEach(rank -> printRankStatistics(rank, matchCounts.getOrDefault(rank, 0)));
    }

    private void printRankStatistics(final Rank rank, final int matchCounts) {
        String RESULT_MESSAGE_FORMAT = "%d개 일치 (%s원) - %d개%n";
        String RESULT_MESSAGE_WITH_BONUS_BALL_FORMAT = "%d개 일치, 보너스 볼 일치(%s원) - %d개%n";

        System.out.printf(
                rank.getBonusMatch() != null && rank.getBonusMatch().matches() ? 
                    RESULT_MESSAGE_WITH_BONUS_BALL_FORMAT : RESULT_MESSAGE_FORMAT,
                rank.getMatchCriteria().getValue(),
                rank.getWinningPrize().getAmount(),
                matchCounts
        );
    }

    private void printYield(final PurchaseAmount purchaseAmount, final LottoGameResult result) {
        System.out.printf("총 수익률은 %.2f입니다.%n", result.getYield(purchaseAmount).getValue());
    }
}
