package study.step3.domain;

import java.util.List;
import java.util.Map;

public class LottoResult {
    private final static String LOTTO_RESULT_RANKS = "winningRanks";

    private final Map<String, Object> result;

    public LottoResult(Map<String, Object> result) {
       this.result = result; 
    }

    public Map<String,Object> getResult(){
        return result;
    }

    public long countRank(WinningRank ranks) {
        List<WinningRank> winningRanks = (List<WinningRank>) result.get(LOTTO_RESULT_RANKS);
        return winningRanks.stream()
                    .filter(winningRank -> winningRank.equals(ranks))
                    .count();
    }
}
