package study.ascii92der.lotto.step3;

import java.util.List;

public class LottoResult {

    private int matchCount;

    public LottoResult(Lotto lotto, List<String> winningNumbers) {
        matchCount = 0;

        for (String winningNumber : winningNumbers) {
            matchCount += calculateMatchedLotto(lotto, Integer.parseInt(winningNumber));
        }
    }

    private int calculateMatchedLotto(Lotto lotto, int winningNumber) {
        if (lotto.hasNumber(winningNumber)) {
            return 1;
        }
        return 0;
    }

    public int matchNumberCount() {
        return matchCount;
    }
}
