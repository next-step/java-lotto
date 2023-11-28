package step2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static step2.domain.LottoWinGenerator.PRIZE_MAP;

public class WinPrizes {

    private static final String PRIZE_FORMAT = "%s개 일치 (%d원)- %d개";

    List<Prize> prizeList = new ArrayList<>();

    public void winPrize(Prize prize) {
        if (prize.isWin()) {
            prizeList.add(prize);
        }
    }

    public List<String> getPrizesFormat() {
        List<String> resultList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : PRIZE_MAP.entrySet()) {
            resultList.add(String.format(PRIZE_FORMAT, entry.getKey(), entry.getValue(), getPrizeListByKey(entry.getKey())));
        }
        return resultList;
    }

    private int getPrizeListByKey(int key) {
        Map<Integer, List<Prize>> collect = prizeList.stream().collect(groupingBy(Prize::getValue));
        return collect.get(key).size();
    }
}
