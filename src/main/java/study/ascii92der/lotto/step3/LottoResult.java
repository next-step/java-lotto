package study.ascii92der.lotto.step3;

import java.util.List;

public class LottoResult {

    private int matchCount;

    public LottoResult(Lotto lotto, List<String> winningNumbers) {
        matchCount = 0;
        for (String winningNumber : winningNumbers) {
            matchCount += lotto.hasNumber(Integer.parseInt(winningNumber));
        }
    }

    public int matchNumberCount() {
        return matchCount;
    }
}
