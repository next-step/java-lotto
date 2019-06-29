package com.java.lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LottoWinningStatistics {
    private static final int MATCH_SCORE = 1;
    private static final int UN_MATCH_SCORE = 0;
    private static final int INITIAL_RATE = 0;

    private Map<Integer, Integer> countByRank = new HashMap<>();
    private Map<LottoReward, Integer> winningStatistics = new TreeMap<>();

    public void findLottoWinning(List<Integer> winningTicket, LottoTickets lottoTickets) {
        for (LottoTicket lottoTicket : lottoTickets.getLottoTickets()) {
            int winningNumberCount = findOnTicket(winningTicket, lottoTicket);
            Integer count = countByRank.get(winningNumberCount);

            countByRank.put(winningNumberCount, (count == null) ? 1 : count + 1);
        }
    }

    private int findOnTicket(List<Integer> winningTicket, LottoTicket lottoTicket) {
        int findNumberCount = 0;
        for (Integer number : lottoTicket.getLottoNumbers()) {
            findNumberCount += numberMatcher(winningTicket, number);
        }
        return findNumberCount;
    }

    private int numberMatcher(List<Integer> winningTicket, Integer number) {
        return winningTicket.contains(number) ? MATCH_SCORE : UN_MATCH_SCORE;
    }

    public int isWinningNumberCount(int winningNumberCount) {
        return countByRank.get(winningNumberCount) == null ? 0 : countByRank.get(winningNumberCount);
    }

    public Map<LottoReward, Integer> isWinningStatistics() {
        for (LottoReward lottoReward : LottoReward.values()) {
            int winningNumberCount = isWinningNumberCount(lottoReward.getMatchNumber());
            winningStatistics.put(lottoReward, winningNumberCount);
        }
        return winningStatistics;
    }

    public float rateOfReturn(int purchaseAmount) {
        int sum = INITIAL_RATE;
        for (LottoReward lottoReward : winningStatistics.keySet()) {
            sum += lottoReward.rewardCheck(lottoReward.getMatchNumber()).reward(winningStatistics.get(lottoReward));
        }
        return (float) sum / purchaseAmount;
    }

}
