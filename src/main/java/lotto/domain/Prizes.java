package lotto.domain;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Prizes {

    private final Money tryMoney;

    private final List<Prize> prizeList;

    public Prizes(List<Prize> prizeList, Money tryMoney) {
        this.prizeList = prizeList;
        this.tryMoney = tryMoney;
    }

    public List<String> getPrizesFormat(String prizeFormat) {
        return Arrays.stream(Prize.values()).filter(Prize::isCanGetPrizeRank).map(rank ->
                String.format(prizeFormat, rank.getCorrectCount(), rank.getWinningMoneyNumber(), howManyGetPrize(rank.getCorrectCount())))
                .sorted()
                .collect(Collectors.toList());
    }

    private int howManyGetPrize(int correctCount) {
        Map<Prize, List<Prize>> prizeMap = prizeList.stream().collect(groupingBy(Function.identity()));
        if (prizeMap.isEmpty() || prizeMap.get(Prize.valueOf(correctCount)) == null) {
            return 0;
        }
        return prizeMap.get(Prize.valueOf(correctCount)).size();
    }

    public Double getProfit() {
        int sum = prizeList.stream().mapToInt(prize -> prize.getWinningMoney().getValue()).sum();
        return (double) (sum / tryMoney.getValue());
    }
}
