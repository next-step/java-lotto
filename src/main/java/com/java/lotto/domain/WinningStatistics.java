package com.java.lotto.domain;

import java.util.Map;
import java.util.TreeMap;

public class WinningStatistics {
    private static final int WINNING_CONDITION = 3;
    private static final int BONUS_CONDITION = 5;
    private static final int INITIAL_RATE = 0;

    private Map<LottoReward, Integer> reward = new TreeMap<>();

    public void findLottoWinning(WinningTicket winningTicket, LottoTickets lottoTickets) {
        for (LottoTicket lottoTicket : lottoTickets.getLottoTickets()) {
            winningTicketExtractor(lottoTicket, winningTicket);
        }
    }

    private void winningTicketExtractor(LottoTicket lottoTicket, WinningTicket winningTicket) {
        int matchCount = winningTicket.matchCount(lottoTicket);
        if (matchCount >= WINNING_CONDITION) {
            LottoReward lottoReward = LottoReward.checkReward(matchCount, isBonus(lottoTicket, winningTicket));
            Integer count = reward.getOrDefault(lottoReward, 0);
            reward.put(lottoReward, count + 1);
        }
    }

    private boolean isBonus(LottoTicket lottoTicket, WinningTicket winningTicket) {
        return isBonusCondition(winningTicket.matchCount(lottoTicket)) && bonusChecker(lottoTicket, winningTicket);
    }

    private boolean isBonusCondition(int matchCount) {
        return matchCount == BONUS_CONDITION;
    }

    private boolean bonusChecker(LottoTicket lottoTicket, WinningTicket winningTicket) {
        return lottoTicket.numbersStream()
                .filter(number -> winningTicket.isBonusNumber(number))
                .findFirst().isPresent();
    }

    public Map<LottoReward, Integer> getReward() {
        return reward;
    }

    public Integer countByReward(LottoReward lottoReward) {
        return reward.get(lottoReward);
    }

    public Integer countByReward(Integer matchCount) {
        return reward.get(LottoReward.checkReward(matchCount));
    }


    public float rateOfReturn(int purchaseAmount) {
        int sum = INITIAL_RATE;
        for (LottoReward lottoReward : reward.keySet()) {
            sum += lottoReward.checkReward(lottoReward.getMatchNumber()).reward(reward.get(lottoReward));
        }
        return (float) sum / purchaseAmount;
    }

}
