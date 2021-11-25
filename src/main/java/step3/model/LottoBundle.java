package step3.model;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class LottoBundle {

    private final List<Lotto> lottoList;

    public LottoBundle(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public List<Lotto> getLottoList() {
        return Collections.unmodifiableList(lottoList);
    }

    public LottoPrize totalReward(Lotto winner, LottoNumber bonusNumber) {
        Map<LottoReward, Long> rewardCountMap = LottoReward.getDefaultRewardMap();
        for (Lotto lotto : lottoList) {
            LottoReward lottoReward = lotto.getReward(winner, bonusNumber);
            rewardCountMap.put(lottoReward, rewardCountMap.get(lottoReward) + 1);
        }
        return new LottoPrize(rewardCountMap, Money.fromLottoBundleSize(lottoList.size()));
    }
}
