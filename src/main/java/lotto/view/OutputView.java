package lotto.view;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.lotto.Numbers;
import lotto.domain.lotto.Rank;

public class OutputView {

    private static final String SPLITTER = ", ";

    private OutputView() {}

    public static void printBuyingTickets(int amount) {
        System.out.println(amount + "개를 구매했습니다.");
    }

    public static void printLottoTicket(Numbers numbers) {
        System.out.print("[");
        System.out.print(
            numbers.get().stream()
                .map(String::valueOf)
                .collect(Collectors.joining(SPLITTER))
        );
        System.out.println("]");
    }

    public static void printResult(BigDecimal calculateRatio) {
        System.out.println("총 수익률은 " + calculateRatio + "입니다.");
    }

    public static void printStat(Map<Rank, Integer> matchForEachTickets) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        Arrays.stream(Rank.values())
            .forEach(rank -> printRank(rank, matchForEachTickets));
    }

    private static void printRank(Rank rank, Map<Rank, Integer> matchForEachTickets) {
        if (rank == Rank.NONE) {
            return;
        }

        if (rank == Rank.SECOND) {
            printBonusRank(rank, matchForEachTickets);
            return;
        }

        System.out.println(rank.getMatches() + "개 일치 (" + rank.getPrize() + "원) - " + matchForEachTickets.getOrDefault(rank, 0) + "개");
    }

    private static void printBonusRank(Rank rank, Map<Rank, Integer> matchForEachTickets) {
        System.out.println(rank.getMatches() + "개 일치, 보너스 볼 일치 (" + rank.getPrize() + "원) - " + matchForEachTickets.getOrDefault(rank, 0) + "개");
    }
}
