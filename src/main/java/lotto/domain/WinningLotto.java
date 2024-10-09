package lotto.domain;

import java.util.List;

public class WinningLotto {
    private static final int DEFAULT_COUNT = 0;
    private static final int PLUS_COUNT = 1;

    private final List<LottoNumber> winningNumbers;

    public WinningLotto(final List<LottoNumber> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public int calculateWinningCount(final Lotto lotto) {
        int matchCount = DEFAULT_COUNT;
        for (LottoNumber number : winningNumbers) {
            matchCount += countSameNumber(lotto, number);
        }
        return matchCount;
    }

    private int countSameNumber(final Lotto lotto, final LottoNumber lottoNumber) {
        if (lotto.hasSameNumber(lottoNumber)) {
            return PLUS_COUNT;
        }
        return DEFAULT_COUNT;
    }
}
