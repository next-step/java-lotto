package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoResults {

    private final List<LottoNumber[]> lottoResults;

    public LottoResults(List<LottoNumber[]> lottoResults) {
        this.lottoResults = lottoResults;
    }

    private static void mapIntToNumber(int[] lottoResult, LottoNumber[] lottoNumbers) {
        for (int i=0; i < lottoResult.length; i++) {
            lottoNumbers[i] = LottoNumber.of(lottoResult[i]);
        }
    }

    public static LottoResults fromIntegers(List<int[]> lottoResultList) {
        List<LottoNumber[]> lottoResults = new ArrayList<>();
        for (int[] lottoResult : lottoResultList) {
            LottoNumber[] lottoNumbers = new LottoNumber[lottoResult.length];
            mapIntToNumber(lottoResult, lottoNumbers);
            lottoResults.add(lottoNumbers);
        }
        return new LottoResults(lottoResults);
    }

    public LottoResults() {
        this.lottoResults = new ArrayList<>();
    }

    public void add(LottoNumber[] generateNumbers) {
        lottoResults.add(generateNumbers);
    }

    public List<int[]> lottoResults() {
        List<int[]> lottoResultList = new ArrayList<>();
        for (LottoNumber[] lottoResult : lottoResults) {
            lottoResultList.add(inputLottoNumber(lottoResult));
        }
        return lottoResultList;
    }

    private int[] inputLottoNumber(LottoNumber[] lottoResult) {
        int[] result = new int[lottoResult.length];
        for (int i = 0; i < lottoResult.length; i++) {
            result[i] = lottoResult[i].getLottoNumber();
        }
        return result;
    }

    public void calculateWinningStatistics(WinningStatistics winningStatistics) {
        for (LottoNumber[] lottoResult : lottoResults) {
            winningStatistics.matchCount(lottoResult);
        }
    }



}
