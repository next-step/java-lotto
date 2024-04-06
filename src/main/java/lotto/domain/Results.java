package lotto.domain;

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
        result.put(Rank.FIRST, 0);
        result.put(Rank.SECOND, 0);
        result.put(Rank.THIRD, 0);
        result.put(Rank.FOURTH, 0);
        result.put(Rank.FIFTH, 0);
        result.put(Rank.MISS, 0);
    }

    public EnumMap<Rank, Integer> of() {
        return result;
    }

    public void countMatchingLottos(Lottos lottos, Lotto winningLotto, Bonus bonus) {
        for (Lotto lotto : lottos.of()) {
            // 당첨번호와 일치하는 로또번호 갯수를 판별한다.
            int matchingCount = lotto.getMatchingCount(winningLotto);

            updateRankLottoMatching(matchingCount, lotto.contains(bonus.getBonusNumber()));
        }
    }

    private void updateRankLottoMatching(int matchingCount, boolean matchBonus) {
        // 각 당첨번호가 몇 자리 일치하는지 추가한다.
        result.put(Rank.valueOf(matchingCount, matchBonus)
                , result.getOrDefault(Rank.valueOf(matchingCount, matchBonus), 0) + 1);
    }
}
