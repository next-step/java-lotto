package lotto.domain;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoWinning {
    private final Map<LottoRank, Integer> winning;

    public LottoWinning() {
        this.winning = Arrays.stream(LottoRank.values())
                .collect(Collectors.toMap(Function.identity(), value -> 0, (x, y) -> y, LinkedHashMap::new));
    }

    public double sumPrizeMoney() {
        double money = 0;
        for (Map.Entry<LottoRank, Integer> entry : winning.entrySet()) {
            LottoRank key = entry.getKey();
            Integer value = entry.getValue();
            money += key.getMoney() * value;
        }
        return money;
    }

    public void put(LottoRank prize) {
        winning.merge(prize, 1, Integer::sum);
    }

    public Integer count(LottoRank prize) {
        return winning.get(prize);
    }

    public Map<LottoRank, Integer> getWinning() {
        return winning;
    }

}
