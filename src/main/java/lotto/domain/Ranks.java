package lotto.domain;

import java.util.HashSet;
import java.util.Set;

public class Ranks {

    private final Set<Rank> ranks;

    public Ranks() {
        this.ranks = new HashSet<>();
        initializeRanks();
    }

    public Ranks(Set<Rank> ranks) {
        this.ranks = ranks;
    }

    private void initializeRanks() {
        ranks.add(new Rank(Reward.THREE.getMatchingCount()));
        ranks.add(new Rank(Reward.FOUR.getMatchingCount()));
        ranks.add(new Rank(Reward.FIVE.getMatchingCount()));
        ranks.add(new Rank(Reward.SIX.getMatchingCount()));
    }

    public Set<Rank> of() {
        return ranks;
    }

    public void countMatchingLottos(Lottos lottos, Set<Integer> winningNo) {
        for (Lotto lotto : lottos.of()) {
            // 당첨번호와 일치하는 로또번호 갯수를 판별한다.
            int matchingCount = lotto.getMatchingCount(winningNo);

            updateRankLottoMatching(matchingCount);
        }
    }

    private void updateRankLottoMatching(int matchingCount) {
        // 각 Rank에 일치하는 갯수를 추가한다.
        ranks.stream()
                .filter(rank -> rank.isMatching(matchingCount))
                .findFirst()
                .ifPresent(Rank::addMatchingLottosCount);
    }
}
