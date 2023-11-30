package step2.domain;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Prizes {

    private static final String PRIZE_FORMAT = "%s개 일치 (%d원)- %d개";

    private static final String PROFIT_FORMAT = "총 수익률은 %,f입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)";

    private final Money tryMoney;

    List<Prize> prizeList = new ArrayList<>();

    public Prizes(List<Prize> prizeList, Money tryMoney) {
        this.prizeList = prizeList;
        this.tryMoney = tryMoney;
    }


    public List<String> getPrizesFormat() {
        return Arrays.stream(Rank.values()).filter(Rank::isCanGetPrizeRank).map(rank ->
                String.format(PRIZE_FORMAT, rank.getCorrectCount(), rank.getWinningMoneyNumber(), howManyGetPrize(rank.getCorrectCount())))
                .sorted()
                .collect(Collectors.toList());
    }

    private int howManyGetPrize(int correctCount) {
        Map<Rank, List<Prize>> collect = prizeList.stream().collect(groupingBy(Prize::getPrizeRank));
        if (collect.isEmpty() || collect.get(Rank.valueOf(correctCount)) == null) {
            return 0;
        }
        return collect.get(Rank.valueOf(correctCount)).size();
    }

    public String getTotalProfit() {
        Double profitNumber = getProfitNumber(prizeList.stream().mapToInt(prize -> prize.getWinningMoney().getValue()).sum());
        return String.format(PROFIT_FORMAT, profitNumber, getProfit(profitNumber));
    }

    private Double getProfitNumber(int profitNumber) {
        Money money = new Money(profitNumber);
        return money.divide(tryMoney);
    }

    private String getProfit(double profit) {
        if (profit > 1) {
            return "이익";
        }

        if (profit < 1) {
            return "손해";
        }
        return "본전";
    }
}
