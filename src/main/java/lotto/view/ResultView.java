package lotto.view;

import lotto.domain.LottoTicket;
import lotto.domain.Rank;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class ResultView {
    private static final int MINIMUM_MONEY_TO_PRINT = 0;

    private ResultView() {}

    public static void printBuyingLotto(final int buyingLotto) {
        System.out.println(buyingLotto + "개를 구매했습니다.");
    }

    public static void printLottoTickets(final List<LottoTicket> lottoTickets) {
        for (LottoTicket lottoTicket : lottoTickets) {
            final String lottoTicketResultString = lottoTicket.getLottoNumbers().stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(","));
            System.out.println(String.format("[%s]", lottoTicketResultString));
        }
    }

    public static void printRankResult(final List<Rank> lottoResults) {
        System.out.println("당첨 통계");
        System.out.println("--------------------------------------");

        Arrays.stream(Rank.values())
                .filter((rank) -> rank.getWinningMoney() > MINIMUM_MONEY_TO_PRINT)
                .forEach((rank) -> {
                    final int countOfRank = getCountOfRank(lottoResults, rank);
                    System.out.println(getRankString(rank, countOfRank));
                });
    }

    private static int getCountOfRank(final List<Rank> lottoResult, Rank rank) {
        return (int) lottoResult.stream()
                .filter(result -> result == rank)
                .count();
    }

    private static String getRankString(final Rank rank, final int countOfRank) {
        return String.format("%d개 일치 (%d원) - (%d)개", rank.getCountOfMatch(), rank.getWinningMoney(), countOfRank);
    }

    public static void printTotalEarningRate(final List<Rank> lottoResults, BigDecimal payMoney) {
        final long winningMoney = lottoResults.stream().mapToLong(Rank::getWinningMoney).sum();

        System.out.println(String.format("총 수익률은 %.2f입니다.",
                BigDecimal.valueOf(winningMoney).divide(payMoney, 3, BigDecimal.ROUND_UP)));
    }

}
