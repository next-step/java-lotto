package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LottoJudge {
    private static final String BONUS_NUMBER_DUPLICATED_MESSAGE = "보너스 번호가 당첨 번호와 겹칩니다.";

    private final LottoNumbers winningLottoNumbers;
    private final LottoNumber bonusNumber;

    private LottoJudge(LottoNumbers winningLottoNumbers, LottoNumber bonusNumber) {
        this.winningLottoNumbers = winningLottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static LottoJudge of(LottoNumbers winningNumbers, LottoNumber bonusNumber) {
        List<Integer> winningNumberList = winningNumbers.value();
        if (winningNumberList.contains(bonusNumber.value())) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATED_MESSAGE);
        }
        return new LottoJudge(winningNumbers, bonusNumber);
    }

    public LottoRewardCountMap countRewards(PurchasedLottos purchasedLottos) {
        List<Lotto> purchaedLottoList = purchasedLottos.value();
        Map<LottoReward, Integer> rewardCountMap = new HashMap<>();
        for (Lotto purchasedLotto : purchaedLottoList) {
            int matchCount = purchasedLotto.getMatchCount(this.winningLottoNumbers);
            boolean matchBonus = purchasedLotto.hasBonusNumber(this.bonusNumber);
            LottoReward reward = LottoReward.valueOf(matchCount, matchBonus);
            rewardCountMap.put(reward, rewardCountMap.getOrDefault(reward, 0) + 1);
        }
        return LottoRewardCountMap.valueOf(rewardCountMap);
    }

    public double calculateRewardPercentage(PurchasedLottos purchasedLottos) {
        LottoRewardCountMap matchCountMap = countRewards(purchasedLottos);
        int totalReward = matchCountMap.getTotalReward();
        return (double) totalReward / (purchasedLottos.size() * Lotto.LOTTO_PRICE);
    }

    public LottoNumbers getWinningLottoNumbers() {
        return this.winningLottoNumbers;
    }

    public LottoNumber getBonusNumber() {
        return this.bonusNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoJudge that = (LottoJudge) o;
        return getBonusNumber() == that.getBonusNumber() && Objects.equals(getWinningLottoNumbers(), that.getWinningLottoNumbers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWinningLottoNumbers(), getBonusNumber());
    }
}
