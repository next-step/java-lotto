package lotto.lotto;

import lotto.dto.LottoResultDTO;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private Map<LottoMarginCalculator, Integer> resultMap = new HashMap<>();

    private void initializeResultMap() {
        resultMap.put(LottoMarginCalculator.RANK_FOUR, 0); //3개일치 4등
        resultMap.put(LottoMarginCalculator.RANK_THREE, 0);
        resultMap.put(LottoMarginCalculator.RANK_TWO, 0);
        resultMap.put(LottoMarginCalculator.RANK_TWO_BONUS, 0); //5개일치 + 보너스 - 2등
        resultMap.put(LottoMarginCalculator.RANK_ONE, 0);
    }

    private final List<Lotto> lottos;

    public LottoResult(List<Lotto> lottos) {
        resultMap = new HashMap<>();
        initializeResultMap();
        this.lottos = lottos;
    }

    /**
     * 로또 일치하는 개수 저장
     */
    public void calculateLotto(LottoWinning winning) {
        for (int i = 0; i < getLottoSize(); i++) {
            Lotto lotto = getLotto(i); // 1,3,4,5,6
            int matchingCount = lotto.calculateMatchingCnt(winning);
            saveResult(matchingCount, lotto.isTwoBonusWin(matchingCount, winning));
        }
    }

    private void saveResult(int matchingCount, boolean isTwoBonusWin) {
        Arrays.stream(LottoMarginCalculator.values()).forEach(
                value -> saveResult(matchingCount, value, isTwoBonusWin));
    }

    private void saveResult(int matchingCount, LottoMarginCalculator value, boolean isTwoBonusWin) {
        if(resultMap.containsKey(value) && value == LottoMarginCalculator.RANK_TWO_BONUS && isTwoBonusWin) {
            resultMap.put(value, resultMap.get(value) + 1);
        }

        if (resultMap.containsKey(value) && value.getMachingCnt() == matchingCount && !isTwoBonusWin) {
            resultMap.put(value, resultMap.get(value) + 1);
        }
    }

    public Lotto getLotto(int i) {
        return lottos.get(i);
    }

    public int getLottoSize() {
        return lottos.size();
    }

    public Map<LottoMarginCalculator, Integer> getResultMap() {
        return resultMap;
    }

    public static LottoResultDTO from(LottoResult result, LottoMargin lottoMargin) {
        return new LottoResultDTO(result.getResultMap(), lottoMargin.getMarginRate());
    }

}
