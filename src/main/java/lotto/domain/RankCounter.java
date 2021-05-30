package lotto.domain;

import lotto.domain.entity.LottoList;
import lotto.domain.entity.Number;
import lotto.domain.entity.Rank;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;

public class RankCounter {

    private final Map<Rank, Integer> counter = new HashMap<>();

    private void addCount(Rank rank) {
        int count = counter.get(rank) != null
                ? counter.get(rank) + 1
                : 1;
        counter.put(rank, count);
    }

    public Integer countByRank(Rank rank) {
        return counter.get(rank) != null ? counter.get(rank) : 0;
    }

    public void entryForEach(BiConsumer<? super Rank, ? super Integer> action) {
        Objects.requireNonNull(action);
        for (Map.Entry<Rank, Integer> entry : counter.entrySet()) {
            Rank rank = entry.getKey();
            Integer integer = entry.getValue();
            action.accept(rank, integer);
        }
    }

    public void counting(LottoList lottoList, Lotto winningLotto, Number bonusNumber) {
        lottoList.forEach(lotto -> {
            Rank rank = Rank.valueOfCountWithMatchBonus(lotto.checkNumbers(winningLotto), isMatchBonus(lotto, bonusNumber));
            addCount(rank);
        });
    }

    private boolean isMatchBonus(Lotto purchased, Number bonusNumber) {
        return purchased.isNumber(bonusNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RankCounter that = (RankCounter) o;
        return Objects.equals(counter, that.counter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(counter);
    }
}
