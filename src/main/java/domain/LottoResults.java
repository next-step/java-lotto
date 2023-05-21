package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoResults {

    private final List<LottoResult> lottoResults;


    public LottoResults(List<LottoResult> lottoResults) {
        this.lottoResults = lottoResults;
    }


    public static LottoResults fromIntegers(List<List<Integer>> lottoResultList) {
        List<LottoResult> lottoResults = new ArrayList<>();
        for (List<Integer> lotto : lottoResultList) {
            LottoResult lottoResult = LottoResult.fromIntegers(lotto);
            lottoResults.add(lottoResult);
        }
        return new LottoResults(lottoResults);
    }

    public LottoResults() {
        this.lottoResults = new ArrayList<>();
    }

    public void add(LottoResult generateNumbers) {
        lottoResults.add(generateNumbers);
    }

    public List<List<Integer>> lottoResults() {
        List<List<Integer>> lottoResultList = new ArrayList<>();
        for (LottoResult lottoResult : lottoResults) {
            lottoResultList.add(inputLottoNumber(lottoResult));
        }
        return lottoResultList;
    }

    private List<Integer> inputLottoNumber(LottoResult lottoResult) {
        return lottoResult.getLottoResult();
    }

    public void calculateWinningStatistics(WinningStatistics winningStatistics) {
        for (LottoResult lottoResult : lottoResults) {
            winningStatistics.matchCount(lottoResult);
        }
    }
}
