package com.lotto.model;

import com.lotto.type.RewardType;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    Map<RewardType, Integer> correctCountMap = new HashMap<>();

    public LottoResult(WinningNumbers winningNumbers, Lottos lottos) {
        RewardType.streamExceptMiss().forEach((rewardType -> correctCountMap.put(rewardType, 0)));

        lottos.lottoStream().forEach((lotto) -> {
            int correctCount = lotto.countCorrectNumbers(winningNumbers.getNumbers());
            boolean isContainBonusNumber = lotto.havingBonusNumber(winningNumbers.getBonusNumber());

            RewardType rewardType = RewardType.getRewardType(correctCount, isContainBonusNumber);

            if (RewardType.MISS.equals(rewardType)) {
                return;
            }

            correctCountMap.put(rewardType, correctCountMap.get(rewardType) + 1);
        });
    }

    public float calculateBenefit(int money) {
        int allRewardValue = correctCountMap.entrySet()
                .stream()
                .mapToInt((entry) -> entry.getKey().getPrice() * entry.getValue())
                .sum();

        return allRewardValue / (money * 1.f);
    }

    public int getCorrectCount(RewardType rewardType) {
        return correctCountMap.getOrDefault(rewardType, 0);
    }
}
