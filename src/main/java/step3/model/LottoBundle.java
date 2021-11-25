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
        Map<Reward, Long> rewardMap = getRewardMap(winner, bonusNumber);
        return new LottoPrize(new LottoWin(rewardMap), Money.fromLottoBundleSize(lottoList.size()));
    }

    private Map<Reward, Long> getRewardMap(Lotto winner, LottoNumber bonusNumber) {
        Map<Reward, Long> rewardMap = Reward.getDefaultRewardMap();
        for (Lotto lotto : lottoList) {
            Reward reward = lotto.getReward(winner, bonusNumber);
            rewardMap.put(reward, rewardMap.get(reward) + 1);
        }
        return rewardMap;
    }
}
