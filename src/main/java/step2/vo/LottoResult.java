package step2.vo;

import java.util.List;

public class LottoResult {

    private final List<Integer> lottoResult;

    public LottoResult(List<Integer> lottoResult) {
        this.lottoResult = lottoResult;
    }

    public int countMatchingNumbers(List<Integer> winNumbers) {
        int matchingCount = 0;
        for (Integer winNum : winNumbers) {
            matchingCount = countMatchNumber(matchingCount, winNum);
        }
        return matchingCount;
    }

    private int countMatchNumber(int matchingCount, Integer winNum) {
        if (lottoResult.contains(winNum)) {
            matchingCount++;
        }
        return matchingCount;
    }

    @Override
    public String toString() {
        return lottoResult.toString();
    }
}
