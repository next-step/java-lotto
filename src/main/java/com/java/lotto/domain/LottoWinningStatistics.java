package com.java.lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoWinningStatistics {
    private static final int MATCH_SCORE = 1;
    private static final int UN_MATCH_SCORE = 0;

    private Map<Integer, Integer> winningRecord = new HashMap<>();

    public void findLottoWinning(List<Integer> winningTicket, LottoTickets lottoTickets) {
        for (LottoTicket lottoTicket : lottoTickets.getLottoTickets()) {
            int winningNumberCount = findOnTicket(winningTicket, lottoTicket);
            Integer count = winningRecord.get(winningNumberCount);
            winningRecord.put(winningNumberCount, (count == null) ? 1 : count + 1);
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

    public int getWinnerCount(int winningNumberCount) {
        return winningRecord.get(winningNumberCount) == null ? 0 : winningRecord.get(winningNumberCount);
    }

    public Map<Integer, Integer> getWinningRecord() {
        return winningRecord;
    }

}
