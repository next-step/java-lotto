package lotto.domain;

import java.util.Map;

public class LottoResult {

    private final Map<Rank, Integer> resultMap;

    public LottoResult(Map<Rank, Integer> resultMap) {
        this.resultMap = resultMap;
    }

    public static LottoResult calculateLottoResult(Lottos lotto, Lotto winLotto) {
        return new LottoResult(lotto.calculateResult(winLotto));
    }

    public int first() {
        return resultMap.get(Rank.FIRST);
    }

    public int second() {
        return resultMap.get(Rank.SECOND);
    }

    public int third() {
        return resultMap.get(Rank.THIRD);
    }

    public int fourth() {
        return resultMap.get(Rank.FOURTH);
    }

    public int last() {
        return resultMap.get(Rank.LAST);
    }

}
