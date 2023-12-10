package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Result {

    private final Map<Rank, Integer> result = new HashMap<>();

    public Result() {
        result.put(Rank.FIRST, 0);
        result.put(Rank.SECOND, 0);
        result.put(Rank.THIRD, 0);
        result.put(Rank.FOURTH, 0);
    }

    public Result(List<Lotto> lottos, LottoNumbers winningNumbers, LottoNumber bonusNumber) {
        result.put(Rank.FIRST, 0);
        result.put(Rank.SECOND, 0);
        result.put(Rank.THIRD, 0);
        result.put(Rank.FOURTH, 0);
        lottos.forEach(l -> {
            Optional<Rank> rank = l.rank(winningNumbers, bonusNumber);
            rank.ifPresent(this::update);
        });
    }

    public Map<Rank, Integer> result() {
        return result;
    }

    public void update(Rank rank) {
        result.replace(
            rank,
            result.get(rank) + 1
        );
    }

    private int totalPrice() {
        int totalPrize = 0;
        for (Map.Entry<Rank, Integer> element : result.entrySet()) {
            totalPrize += element.getValue() * element.getKey().prizeAmount();
        }
        return totalPrize;
    }

    public long rateOfReturn(int money) {
        return (long) this.totalPrice() / money * 100;
    }
}
