package lotto.lotto;

import lotto.dto.LottoResultDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private Map<Integer, Integer> resultMap; // 3개/4개/5개/6개 일치

    private void initializeResultMap() {
        resultMap.put(3, 0);
        resultMap.put(4, 0);
        resultMap.put(5, 0);
        resultMap.put(6, 0);
    }

    private final List<Lotto> lottos;

    public LottoResult(List<Lotto> lottos) {
        resultMap = new HashMap<>();
        initializeResultMap();
        this.lottos = lottos;
    }

    /**
     * 로또 일치하는 개수 저장
     * */
    public void calculateLotto(LottoWinning winning) {
        for (int i = 0; i < getLottoSize(); i++) {
            Lotto lotto = getLotto(i); // 1,3,4,5,6
            saveResult(lotto.calculateMatchingCnt(winning));
        }
    }

    private void saveResult(int matchesIdx) {
        if (resultMap.keySet().contains(matchesIdx)) {
            resultMap.put(matchesIdx, resultMap.get(matchesIdx) + 1);
        }
    }

    public Lotto getLotto(int i) {
        return lottos.get(i);
    }

    public int getLottoSize() {
        return lottos.size();
    }

    public Map<Integer, Integer> getResultMap() {
        return resultMap;
    }

    public static LottoResultDTO from(LottoResult result, LottoMargin lottoMargin) {
        return new LottoResultDTO(result.getResultMap(), lottoMargin.getMarginRate());
    }

}
