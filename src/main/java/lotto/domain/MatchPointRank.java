package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MatchPointRank {
    private final Map<MatchPoint, Integer> matchPointMap;

    public MatchPointRank() {
        this.matchPointMap = new HashMap<>();

        for (MatchPoint matchValue : MatchPoint.values()) {
            this.matchPointMap.put(matchValue, 0);
        }
    }

    public void compareMatchPoint(Lotto lotto) {
        MatchPoint mp = MatchPoint.findMatchPoint(lotto.getLottoOriginMatchNumber(), lotto.getLottoBonusMatchNumber());
        int sameNum = this.matchPointMap.get(mp);
        this.matchPointMap.put(mp, sameNum + 1);
    }

    public Set<MatchPoint> getMatchPointSet() {
        return this.matchPointMap.keySet();
    }

    public int getMatchPoint(MatchPoint mp) {
        return this.matchPointMap.get(mp);
    }

}
