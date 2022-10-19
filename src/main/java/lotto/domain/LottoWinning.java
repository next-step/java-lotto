package lotto.domain;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoWinning {
    private final Map<LottoPrize, Integer> winning;

    public LottoWinning() {
        this.winning = Arrays.stream(LottoPrize.values())
                .collect(Collectors.toMap(Function.identity(), value -> 0, (x, y) -> y, LinkedHashMap::new));
    }

    public double sumPrizeMoney() {
        double money = 0;
        for (Map.Entry<LottoPrize, Integer> entry : winning.entrySet()) {
            LottoPrize key = entry.getKey();
            Integer value = entry.getValue();
            money += key.getMoney() * value;
        }
        return money;
    }

    public void put(LottoPrize prize) {
        winning.merge(prize, 1, Integer::sum);
    }

    public Integer count(LottoPrize prize) {
        return winning.get(prize);
    }

    public Map<LottoPrize, Integer> getWinning() {
        return winning;
    }

}
