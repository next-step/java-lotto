package lotto.dto;

import java.util.HashMap;
import java.util.Map;

public class LottoResultDto {

    private final Map<Long, Integer> rewardBoard;
    private final Map<Long, Long> prizeMap;
    private String earningRate;

    public LottoResultDto() {
        rewardBoard = new HashMap<>();
        prizeMap = new HashMap<>();
    }

    public void putRewardRecord(long countMatches) {
        if (rewardBoard.containsKey(countMatches)) {
            rewardBoard.put(countMatches, rewardBoard.get(countMatches) + 1);
            return;
        }
        rewardBoard.put(countMatches, 1);
    }

    public void putPrizeMap(long countMatches, long prize) {
        if (!prizeMap.containsKey(countMatches)) {
            prizeMap.put(countMatches, prize);
        }
    }

    public void setEarningRate(String earningRate) {
        this.earningRate = earningRate;
    }

    public Long getPrizeByCountMatches(long countMatches) {
        return prizeMap.get(countMatches);
    }

    public Integer getWinnerCountByCountMatches(long countMatches) {
        if (rewardBoard.containsKey(countMatches)) {
            return rewardBoard.get(countMatches);
        }
        return 0;
    }

    public String getEarningRate() {
        return earningRate;
    }

}
