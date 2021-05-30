package lotto.domain;

import lotto.domain.entity.LottoList;
import lotto.domain.entity.Number;
import lotto.domain.entity.Rank;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RankCounter {

    private final Map<Rank, Integer> counter = new HashMap<>();

    public void addCount(Rank rank) {
        int count = counter.get(rank) != null
                ? counter.get(rank) + 1
                : 1;
        counter.put(rank, count);
    }

    public Integer countByRank(Rank rank) {
        return counter.get(rank) != null ? counter.get(rank) : 0;
    }

    public Map<Rank, Integer> counter() {
        return counter;
    }

    public void counting(LottoList lottoList, Lotto winningLotto, Number bonusNumber) {
        boolean matchBonus = false;
        for (Lotto purchased : lottoList.foreach()) {
            matchBonus = isMatchBonus(purchased, bonusNumber);
            checkRanking(purchased.checkNumbers(winningLotto), matchBonus);
        }
    }

    private void checkRanking(int count, boolean matchBonus) {
        if (count == 3) {
            addCount(Rank.FIFTH);
        }
        if (count == 4) {
            addCount(Rank.FOURTH);
        }
        if (count == 5 && !matchBonus) {
            addCount(Rank.THIRD);
        }
        if (count == 5 && matchBonus) {
            addCount(Rank.SECOND);
        }
        if (count == 6) {
            addCount(Rank.FIRST);
        }
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

    @Override
    public String toString() {
        return "RankCounter{" +
                "counter=" + counter +
                '}';
    }
}
