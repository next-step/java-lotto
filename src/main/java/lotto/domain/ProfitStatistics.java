package lotto.domain;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ProfitStatistics {

    private static final int WIN_MIN_COUNT = 3;
    private List<Integer> winningList;
    private int money;

    public ProfitStatistics(List<Integer> winningList, int money) {
        this.winningList = winningList;
        this.money = money;
    }

    public ResultDTO analysis() {
        HashMap<Prize, Integer> resultMap = new HashMap<>();
        AtomicInteger startIndex = new AtomicInteger(WIN_MIN_COUNT);

        winningList.stream().forEach( winRanking -> {
            resultMap.put(getMatchPrize(startIndex.getAndIncrement()), winRanking);
        });

        return new ResultDTO(resultMap, getProfitRatio());
    }

    private Prize getMatchPrize(int matchCount) {
        Prize properPrize = Arrays.stream(Prize.values())
                .filter(prize -> prize.getMatchCount() == matchCount)
                .findFirst()
                .orElseThrow();

        return properPrize;
    }

    public double getProfitRatio() {
        return (double) calculateProfit() / money;
    }

    private int calculateProfit() {
        AtomicInteger startIndex = new AtomicInteger(WIN_MIN_COUNT);

        int prizeSum = winningList.stream()
                .mapToInt(winCount -> calculateWinningList(winCount, startIndex.getAndIncrement()))
                .sum();

        return prizeSum;
    }

    private int calculateWinningList(int winCount, int startIndex) {
        if(winCount > 0) {
            return getMatchPrize(startIndex).getWinningPrize();
        }
        return 0;
    }
}
