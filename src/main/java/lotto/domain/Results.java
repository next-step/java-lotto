package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;

public class Results {

    private EnumMap<Rank, Integer> result = new EnumMap<>(Rank.class);

    public Results() {
        initializeResults();
    }

    public Results(EnumMap<Rank, Integer> result) {
        this.result = result;
    }

    private void initializeResults() {
        Arrays.stream(Rank.values())
                .forEach(rank -> result.put(rank, 0));
    }

    public EnumMap<Rank, Integer> of() {
        return result;
    }

    public void countMatchingLottos(Lottos lottos, WinningLotto winningLotto) {
        for (Lotto lotto : lottos.of()) {
            // 당첨번호와 일치하는 로또번호 갯수를 판별한다.
            int matchingCount = lotto.getMatchingCount(winningLotto.getLotto());

            updateRankLottoMatching(matchingCount, lotto.contains(winningLotto.getBonus()));
        }
    }

    private void updateRankLottoMatching(int matchingCount, boolean matchBonus) {
        // 각 당첨번호가 몇 자리 일치하는지 추가한다.
        result.put(Rank.valueOf(matchingCount, matchBonus)
                , result.getOrDefault(Rank.valueOf(matchingCount, matchBonus), 0) + 1);
    }
}
