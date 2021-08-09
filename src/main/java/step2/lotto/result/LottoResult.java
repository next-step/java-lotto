package step2.lotto.result;

import step2.lotto.Lotto;
import step2.lotto.LottoNumber;
import step2.lotto.LottoPrize;

public class LottoResult {

    private final long countOfMatches;
    private final LottoPrize lottoPrize;

    public LottoResult(LottoNumber winningNumber, Lotto lotto) {
        LottoNumber lottoNumber = lotto.getNumber();
        long countOfMatches = winningNumber.countOfMatches(lottoNumber);
        this.countOfMatches = countOfMatches;
        this.lottoPrize = LottoPrize.getLottoPrize(countOfMatches);
    }

    public long getCountOfMatches() {
        return countOfMatches;
    }

    public LottoPrize getLottoPrize() {
        return lottoPrize;
    }
}
