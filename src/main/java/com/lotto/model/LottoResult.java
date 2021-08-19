package com.lotto.model;

import com.lotto.type.RewardType;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class LottoResult {
    Map<Integer, Integer> correctCountMap = new HashMap<>();

    public LottoResult(WinningNumbers winningNumbers, Lottos lottos) {
        Arrays.stream(RewardType.values()).forEach((rewardType -> correctCountMap.put(rewardType.getNumberOfCorrect(), 0)));

        lottos.lottoStream().forEach((lotto) -> {
            int correctCount = winningNumbers.checkCorrectCount(lotto);

            if (correctCount < 3) {
                return;
            }
            correctCountMap.put(correctCount, correctCountMap.get(correctCount) + 1);
        });
    }

    public Stream<Map.Entry<Integer, Integer>> streamCorrectCountMap() {
        return correctCountMap.entrySet().stream();
    }
}
