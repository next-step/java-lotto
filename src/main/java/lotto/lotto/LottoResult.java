package lotto.lotto;

import lotto.dto.LottoResultDTO;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    private Map<LottoRank, Integer> resultMap = new HashMap<>();

    public LottoResult() {
        initializeResultMap();
    }

    private void initializeResultMap() {
        resultMap.put(LottoRank.RANK_FOUR, 0); //3개일치 4등
        resultMap.put(LottoRank.RANK_THREE, 0);
        resultMap.put(LottoRank.RANK_TWO, 0);
        resultMap.put(LottoRank.RANK_TWO_BONUS, 0); //5개일치 + 보너스 - 2등
        resultMap.put(LottoRank.RANK_ONE, 0);
    }

    public void updateResult(LottoRank foundPrice) {
        if (foundPrice != null) {
            resultMap.put(foundPrice, resultMap.get(foundPrice) + 1);
        }
    }

    public Map<LottoRank, Integer> getResultMap() {
        return resultMap;
    }

    public static LottoResultDTO from(LottoResult result, LottoMargin lottoMargin) {
        return new LottoResultDTO(result.getResultMap(), lottoMargin.getMarginRate());
    }

}
