package study.ascii92der.lotto.step3n4;

import java.util.List;

public class LottoResult {

    private LottoWinner lottoWinner;

    public LottoResult(Lotto lotto, List<String> winningNumbers, int bonusNumber) {
        int matchCount = 0;
        for (String winningNumber : winningNumbers) {
            matchCount += calculateMatchedLotto(lotto, Integer.parseInt(winningNumber));
        }
        lottoWinner = LottoWinner.valueOf(matchCount, lotto.hasNumber(bonusNumber));
    }

    private int calculateMatchedLotto(Lotto lotto, int winningNumber) {
        if (lotto.hasNumber(winningNumber)) {
            return 1;
        }
        return 0;
    }

    public LottoWinner result() {
        return lottoWinner;
    }
}
