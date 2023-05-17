package lotto.domain;

import lotto.util.RewardTable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningStatistics {
    private static final Long BASIC_REWARD_SET_ZERO = 0L;

    private List<LottoNumber> lottoResultNumbers;
    private Map<RewardTable, Long> resultGameStatistics;
    private LottoNumber lottoBonusNumber;

    public WinningStatistics(List<LottoNumber> lottoResultNumbers, LottoNumber lottoBonusNumber) {
        initRewardMap();

        this.lottoResultNumbers = lottoResultNumbers;
        this.lottoBonusNumber = lottoBonusNumber;
    }

    public Map<RewardTable, Long> resultLottoGame(List<LottoTicket> lottoTickets) {

        for(LottoTicket lottoTicket : lottoTickets) {
            int matchCount = lottoTicket.matchLottoNumberCount(this.lottoResultNumbers);
            addWinningStatistics(matchCount, lottoTicket.hasBonusBall(this.lottoBonusNumber));
        }

        return this.resultGameStatistics;
    }

    private void addWinningStatistics(int matchCount, Boolean isBouns) {
        this.resultGameStatistics.put(RewardTable.of(matchCount, isBouns)
                , this.resultGameStatistics.getOrDefault(RewardTable.of(matchCount, isBouns), 0L) + 1);
    }

    private void initRewardMap() {
        Map<RewardTable, Long> map = new HashMap<>();

        RewardTable[] rewardTables = RewardTable.values();

        for (RewardTable rewardTable : rewardTables) {
            map.put(rewardTable, BASIC_REWARD_SET_ZERO);
        }

        this.resultGameStatistics = map;
    }
}
