package lotto.domain;

import java.util.EnumMap;
import java.util.Set;

public class Results {

    private EnumMap<Reward, Integer> result = new EnumMap<>(Reward.class);

    public Results() {
        initializeResults();
    }

    public Results(EnumMap<Reward, Integer> result) {
        this.result = result;
    }

    private void initializeResults() {
        result.put(Reward.THREE, 0);
        result.put(Reward.FOUR, 0);
        result.put(Reward.FIVE, 0);
        result.put(Reward.SIX, 0);
    }

    public EnumMap<Reward, Integer> of() {
        return result;
    }

    public void countMatchingLottos(Lottos lottos, Lotto winningLotto) {
        for (Lotto lotto : lottos.of()) {
            // 당첨번호와 일치하는 로또번호 갯수를 판별한다.
            int matchingCount = lotto.getMatchingCount(winningLotto);

            updateRankLottoMatching(matchingCount);
        }
    }

    private void updateRankLottoMatching(int matchingCount) {
        // 각 당첨번호가 몇 자리 일치하는지 추가한다.
        result.put(Reward.fromMatchingCount(matchingCount)
                , result.getOrDefault(Reward.fromMatchingCount(matchingCount), 0) + 1);
    }
}
