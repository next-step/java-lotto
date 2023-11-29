package step2.domain;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Prizes {

    private static final String PRIZE_FORMAT = "%s개 일치 (%d원)- %d개";

    List<Prize> prizeList = new ArrayList<>();

    public Prizes(List<Prize> prizeList) {
        this.prizeList = prizeList;
    }

    public void winPrize(Prize prize, WinGenerator winGenerator) {
        prizeList.add(prize);
    }

    public List<String> getPrizesFormat() {
        return Arrays.stream(Rank.values()).filter(Rank::isCanGetPrizeRank).map(rank ->
                String.format(PRIZE_FORMAT, rank.getCorrectCount(), rank.getWinningMoneyNumber(), howManyGetPrize(rank.getCorrectCount())))
            .collect(Collectors.toList());
    }

    private int howManyGetPrize(int key) {
        Map<Rank, List<Prize>> collect = prizeList.stream().collect(groupingBy(Prize::getPrizeRank));
        if (collect.isEmpty()) {
            System.out.println("뭐야");
            return 0;
        }
        return collect.get(Rank.valueOf(key)).size();
    }
}
