package lottoauto;

import java.util.*;

public class LottoStatement {
    private final Map<LottoRule, Integer> hitCountMap = new HashMap<>();

    public LottoStatement() {
        hitCountMap.put(LottoRule.THREE_HIT, 0);
        hitCountMap.put(LottoRule.FOUR_HIT, 0);
        hitCountMap.put(LottoRule.FIVE_HIT, 0);
        hitCountMap.put(LottoRule.SIX_HIT, 0);
    }

    public void judge(HitCount hitCount) {
        Set<LottoRule> keySet = hitCountMap.keySet();
        for (LottoRule lottoRule : keySet) {
            isEqualsHitCount(hitCount, lottoRule);
        }
    }

    private void isEqualsHitCount(HitCount hitCount, LottoRule lottoRule) {
        if(lottoRule.isEqualsHitCount(hitCount)) {
            int count = hitCountMap.get(lottoRule);
            hitCountMap.put(lottoRule, count + 1);
        }
    }

    public Integer accumulatedHitCount(LottoRule lottoRule) {
        return hitCountMap.get(lottoRule);
    }

}
