package step2.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PurChasedLotto {

    private List<Lotto> purChasedLotto;
    private Map<Rank, Integer> rankInfo = Rank.getInitRankInfo();

    public PurChasedLotto(List<Lotto> purChasedLotto) {
        this.purChasedLotto = purChasedLotto;
    }

    public void matchNumber(Lotto winningLotto) {
        for (Lotto lotto : purChasedLotto) {
            updateRankInfo(lotto.match(winningLotto));
        }
    }

    public Map<Rank, Integer> getRankInfo() {
        return rankInfo;
    }

    public int getTotalPrize() {
        return rankInfo.keySet().stream()
                .mapToInt((rank) -> rank.getPrize() * rankInfo.get(rank))
                .reduce((prize1, prize2) -> prize1 + prize2)
                .getAsInt();
    }

    private void updateRankInfo(Rank rank) {
        if (rankInfo.containsKey(rank)) {
            rankInfo.replace(rank, rankInfo.get(rank) + 1);
            return;
        }
    }
}
