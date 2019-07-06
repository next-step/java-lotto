package com.java.lotto.domain;

import java.util.Map;
import java.util.TreeMap;

public class WinningStatistics {
    private static final int WINNING_CONDITION = 3;
    private static final int BONUS_CONDITION = 5;
    private static final int INIT_NUMBER = 0;

    private final WinningTicket winningTicket;
    private final Map<LottoReward, Integer> reward = new TreeMap<>();
    private final float winningRate;

    public WinningStatistics(WinningTicket winningTicket, Lotto lotto) {
        this.winningTicket = winningTicket;
        findLottoWinning(lotto.getLottoTickets());
        this.winningRate = rateOfReturn(lotto.getPurchaseAmount());

    }

    private void findLottoWinning(LottoTickets lottoTickets) {
        for (LottoTicket lottoTicket : lottoTickets.getLottoTickets()) {
            winningTicketExtractor(lottoTicket);
        }
    }

    private void winningTicketExtractor(LottoTicket lottoTicket) {
        int matchCount = winningTicket.matchCount(lottoTicket);
        if (matchCount >= WINNING_CONDITION) {
            LottoReward lottoReward = LottoReward.checkReward(matchCount, isBonus(lottoTicket));
            Integer count = reward.getOrDefault(lottoReward, INIT_NUMBER);
            reward.put(lottoReward, count + 1);
        }
    }

    private boolean isBonus(LottoTicket lottoTicket) {
        return winningTicket.matchCount(lottoTicket) == BONUS_CONDITION && bonusChecker(lottoTicket);
    }

    private boolean bonusChecker(LottoTicket lottoTicket) {
        return lottoTicket.numbersStream()
                .filter(number -> winningTicket.isBonusNumber(number))
                .findFirst().isPresent();
    }

    public Integer countByReward(LottoReward lottoReward) {
        return reward.get(lottoReward) == null ? INIT_NUMBER : reward.get(lottoReward);
    }

    public Integer countByReward(Integer matchCount) {
        return reward.get(LottoReward.checkReward(matchCount));
    }

    public float rateOfReturn(int purchaseAmount) {
        int sum = INIT_NUMBER;
        for (LottoReward lottoReward : reward.keySet()) {
            sum += lottoReward.checkReward(lottoReward.getMatchNumber()).reward(reward.get(lottoReward));
        }
        return (float) sum / purchaseAmount;
    }

    public float getWinningRate(){
        return winningRate;
    }

}
