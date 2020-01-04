package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    private Map<Rank, Integer> matchResult = new HashMap<>();

    public LottoResult() {
        for (Rank rank : Rank.values()) {
            matchResult.put(rank, 0);
        }
    }

    public void match(LottoBundle lottoBundle, WinningLotto winningLotto) {
        lottoBundle.stream()
                .map(winningLotto::matchRank)
                .forEach(this::putRank);
    }

    private void putRank(Rank rank) {
        matchResult.put(rank, matchResult.get(rank) + 1);
    }

    public int getCount(Rank rank) {
        return matchResult.get(rank);
    }

    public int getAmount() {
        return Arrays.stream(Rank.values())
                .mapToInt(rank -> matchResult.get(rank) * rank.getReward())
                .sum();
    }

    public float calcualteEarningRate(int payment) {
        return (float) this.getAmount() / (float) payment;
    }
}
