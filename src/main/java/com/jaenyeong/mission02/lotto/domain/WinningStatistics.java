package com.jaenyeong.mission02.lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class WinningStatistics {
    private static final String WINNING_PRIZE_PRINT_FORMAT = "%d개 일치 (%d원) - %d개";
    private static final String WINNING_PRIZE_RATE_PRINT_FORMAT = "총 수익률은 %.2f입니다";
    private static final String TEXT_PRIZE_LOSS = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    private static final int NONE = 0;
    private static final int ADD = 1;
    private static final int BREAK_EVEN = 1;
    private final Map<Rank, Integer> lotteryRanksMap;
    private final int buyPrice;
    private final long prizeMoney;

    private WinningStatistics(final Map<Rank, Integer> lotteryRanksMap, final int buyPrice) {
        this.lotteryRanksMap = new EnumMap<>(lotteryRanksMap);
        this.buyPrice = buyPrice;

        this.prizeMoney = this.lotteryRanksMap.keySet().stream()
            .filter(Rank::isNotMissMatch)
            .mapToLong(Rank::getWinningPrize)
            .reduce(0L, Long::sum);
    }

    private String parseWinningPrizePrintFormat(final Rank rank) {
        return String.format(WINNING_PRIZE_PRINT_FORMAT,
            rank.getCountOfMatch(),
            rank.getWinningPrize(),
            numberOfTheRank(rank));
    }

    public static WinningStatistics of(final List<Rank> lotteryRanks, final int buyPrice) {
        final Map<Rank, Integer> lotteryRanksMap = lotteryRanks.stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(rank -> ADD)));

        return new WinningStatistics(lotteryRanksMap, buyPrice);
    }

//    public int numberOfGames() {
//        return lotteryRanksMap.values()
//            .stream()
//            .reduce(Integer::sum)
//            .orElse(NONE);
//    }

    public int numberOfTheRank(final Rank rank) {
        return lotteryRanksMap.getOrDefault(rank, NONE);
    }

    public List<String> getPrintFormatWinningResultStatistics() {
        return this.lotteryRanksMap.keySet().stream()
            .filter(Rank::isNotMissMatch)
            .map(this::parseWinningPrizePrintFormat)
            .collect(toList());
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    public String getPrintFormatPrizeRate() {
        float prizeRate = ((float) this.prizeMoney) / this.buyPrice;

        final String textPrizeRate = String.format(WINNING_PRIZE_RATE_PRINT_FORMAT,
            prizeRate);

        return (prizeRate >= BREAK_EVEN) ? textPrizeRate : textPrizeRate + " " + TEXT_PRIZE_LOSS;
    }
}
