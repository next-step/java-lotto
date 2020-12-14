package com.jaenyeong.mission02.lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class WinningStatistics {
    private static final String PRINT_FORMAT = "%d개 일치 (%d원) - %d개";
    private static final int NONE = 0;
    private static final int ADD = 1;
    private final Map<Rank, Integer> lotteryRanksMap;
    private final int buyPrice;
    private final int prizeMoney;
    private final List<String> printFormatStatistics;

    private WinningStatistics(final Map<Rank, Integer> lotteryRanksMap, final int buyPrice) {
        this.lotteryRanksMap = new EnumMap<>(lotteryRanksMap);
        this.buyPrice = buyPrice;

        this.prizeMoney = this.lotteryRanksMap.keySet().stream()
            .filter(Rank::isNotMissMatch)
            .map(Rank::getWinningPrize)
            .reduce(0, Integer::sum);

        printFormatStatistics = this.lotteryRanksMap.keySet().stream()
            .filter(Rank::isNotMissMatch)
            .map(integer -> String.format(PRINT_FORMAT,
                integer.getCountOfMatch(),
                integer.getWinningPrize(),
                numberOfTheRank(integer)))
            .collect(toList());
    }

    public static WinningStatistics of(final List<Rank> lotteryRanks, final int buyPrice) {
        final Map<Rank, Integer> lotteryRanksMap = lotteryRanks.stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(rank -> ADD)));

        return new WinningStatistics(lotteryRanksMap, buyPrice);
    }

    public int numberOfGames() {
        return lotteryRanksMap.values()
            .stream()
            .reduce(Integer::sum)
            .orElse(NONE);
    }

    public int numberOfTheRank(final Rank rank) {
        return lotteryRanksMap.getOrDefault(rank, NONE);
    }

    public List<String> getPrintFormatStatistics() {
        return this.printFormatStatistics;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
