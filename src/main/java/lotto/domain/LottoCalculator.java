package lotto.domain;

import java.util.List;

public class LottoCalculator {

    private static final LottoCalculator INSTANCE = new LottoCalculator();

    private LottoCalculator() {
    }

    public static LottoCalculator getInstance() {
        return INSTANCE;
    }

    public Ranking calculate(final List<LottoNumber> winningNumbers,
        List<LottoNumber> userNumbers, LottoNumber bonusNumber) {

        LottoResult result = new LottoResult(0, false);
        LottoResult lottoResult = result.countLotteryNumber(winningNumbers, userNumbers,
            bonusNumber);

        return Ranking.judgeRanking(lottoResult);
    }

}
