package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LottoResults {

    private final List<LottoResult> lottoResults;


    public LottoResults(List<LottoResult> lottoResults) {
        this.lottoResults = lottoResults;
    }


    public static LottoResults fromIntegers(List<Set<Integer>> lottoResultList) {
        List<LottoResult> lottoResults = new ArrayList<>();
        for (Set<Integer> lotto : lottoResultList) {
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

    public List<List<Integer>> lottoResultsToInt() {
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
