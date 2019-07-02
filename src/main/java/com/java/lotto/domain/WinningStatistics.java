package com.java.lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class WinningStatistics {
    private static final int WINNING_CONDITION = 3;
    private static final int INITIAL_RATE = 0;

    private Map<LottoReward, Integer> reward = new TreeMap<>();

    public void findLottoWinning(WinningNumbers winningNumbers, LottoTickets lottoTickets) {
        for (LottoTicket lottoTicket : lottoTickets.getLottoTickets()) {
            winningTicketExtractor(lottoTicket, winningNumbers);
        }
    }

    private void winningTicketExtractor(LottoTicket lottoTicket, WinningNumbers winningNumbers) {
        Integer matchCount = winningNumbers.matchCount(lottoTicket);
        if (matchCount >= WINNING_CONDITION) {
            LottoReward lottoReward = rewardChecker(matchCount, bonusChecker(lottoTicket, winningNumbers));
            Integer count = reward.get(lottoReward);
            reward.put(lottoReward, (count == null) ? 1 : count + 1);
        }
    }

    private Boolean bonusChecker(LottoTicket lottoTicket, WinningNumbers winningNumbers) {
        return lottoTicket.numbersStream()
                .filter(number -> winningNumbers.isBonusNumber(number))
                .findFirst().isPresent();
    }

    private LottoReward rewardChecker(int matchCount, Boolean bonus) {
        return matchCount == 5 && bonus ? LottoReward.MATCH_FIVE_BONUS : LottoReward.rewardCheck(matchCount);
    }

    public Map<LottoReward, Integer> getReward() {
        return reward;
    }

    public Integer countByReward(LottoReward lottoReward){
        return reward.get(lottoReward);
    }


    public float rateOfReturn(int purchaseAmount) {
        int sum = INITIAL_RATE;
        for (LottoReward lottoReward : reward.keySet()) {
            sum += lottoReward.rewardCheck(lottoReward.getMatchNumber()).reward(reward.get(lottoReward));
        }
        return (float) sum / purchaseAmount;
    }

}
