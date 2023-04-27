package step2.vo;

import step2.service.Lotto;

import java.util.List;

public class LottoResult {

    private final Lotto lotto;

    public LottoResult(Lotto lotto) {
        this.lotto = lotto;
    }

    public int countMatchingNumbers(List<Integer> winNumbers) {
        int matchingCount = 0;
        for (Integer winNum : winNumbers) {
            matchingCount = countMatchNumber(matchingCount, winNum);
        }
        return matchingCount;
    }

    private int countMatchNumber(int matchingCount, int winNum) {
        if (lotto.containWinNum(winNum)) {
            matchingCount++;
        }
        return matchingCount;
    }

    public String toStringLottoNumbers() {
        return this.lotto.toStringLottoNumbers();
    }
}
