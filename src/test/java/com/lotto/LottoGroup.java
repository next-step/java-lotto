package com.lotto;

import java.util.*;

public class LottoGroup {
    private List<Lotto> lottoList;

    public LottoGroup(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public int size() {
        return lottoList.size();
    }

    public Map<LottoReward, Integer> winningLottoMap(Set<Integer> winningNumbers) {
        Map<LottoReward, Integer> winningLottoMap = new HashMap<>();
        for(Lotto lotto : lottoList) {
            LottoReward reward = lotto.reward(winningNumbers);
            winningLottoMap.put(reward, winningLottoMap.get(reward) != null ? winningLottoMap.get(reward) + 1 : 1);
        }

        return winningLottoMap;
    }

    public int totalReward(Set<Integer> winningNumbers) {
        int totalReward = 0;
        Map<LottoReward, Integer> winningLottoMap = winningLottoMap(winningNumbers);
        for(LottoReward reward : winningLottoMap.keySet()) {
            totalReward += reward.totalReward(winningLottoMap.get(reward));
        }

        return totalReward;
    }
}
