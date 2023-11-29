package step2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class Prizes {

    private static final String PRIZE_FORMAT = "%s개 일치 (%d원)- %d개";

    List<Prize> prizeList = new ArrayList<>();

    public void winPrize(Prize prize) {
//        if (prize.isWin()) {
            prizeList.add(prize);
//        }
    }

    public List<String> getPrizesFormat() {
        List<String> resultList = new ArrayList<>();
        for (Rank rank : Rank.values()) {
            resultList.add(String.format(PRIZE_FORMAT, rank.getCorrectCount(), rank.getWinningMoneyNumber(), getPrizeListByKey(rank.getCorrectCount())));
        }
        return resultList;
    }

    private int getPrizeListByKey(int key) {
        Map<Rank, List<Prize>> collect = prizeList.stream().collect(groupingBy(Prize::getPrizeRank));
        return collect.get(Rank.valueOf(key)).size();
    }
}
