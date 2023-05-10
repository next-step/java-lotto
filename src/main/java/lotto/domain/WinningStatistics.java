package lotto.domain;

import lotto.util.RewardTable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningStatistics {
    private static final int MINIMUM_MATCH_COUNT = 3;
    private static final int BASIC_REWARD_SET_ZERO = 0;

    private List<Integer> lottoResultNumbers;
    private Map<RewardTable, Integer> resultGameStatistics;
    private int lottoBonusNumber;

    public WinningStatistics(List<Integer> lottoResultNumbers, int lottoBonusNumber) {
        makeResultMap();

        this.lottoResultNumbers = lottoResultNumbers;
        this.lottoBonusNumber = lottoBonusNumber;
    }

    public Map<RewardTable, Integer> resultLottoGame(List<LottoTicket> lottoTickets) {

        for(LottoTicket lottoTicket : lottoTickets) {
            int matchCount = lottoTicket.matchLottoNumberCount(this.lottoResultNumbers);
            addWinningStatistics(matchCount, lottoTicket.hasBonusBall(this.lottoBonusNumber));
        }

        return this.resultGameStatistics;
    }

    private void addWinningStatistics(int matchCount, Boolean isBouns) {
        if (matchCount >= MINIMUM_MATCH_COUNT) {
            this.resultGameStatistics.put(RewardTable.of(matchCount, isBouns)
                    , this.resultGameStatistics.getOrDefault(RewardTable.of(matchCount, isBouns), 0) + 1);
        }
    }

    private void makeResultMap() {
        Map<RewardTable, Integer> map = new HashMap<>();

        RewardTable[] rewardTables = RewardTable.values();

        for (RewardTable rewardTable : rewardTables) {
            map.put(rewardTable, BASIC_REWARD_SET_ZERO);
        }

        this.resultGameStatistics = map;
    }
}
