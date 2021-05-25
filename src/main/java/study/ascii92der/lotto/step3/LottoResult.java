package study.ascii92der.lotto.step3;

import java.util.List;

public class LottoResult {

    private int matchCount;

    public LottoResult(Lotto lotto, List<Integer> winningNumbers) {
        matchCount = 0;
        for (Integer winningNumber : winningNumbers) {
            matchCount += lotto.hasNumber(winningNumber);
        }
    }

    public int matchNumberCount() {
        return matchCount;
    }
}
