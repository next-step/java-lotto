package lotto.domain;

import java.util.LinkedHashSet;
import java.util.Set;

public class WinningLotto {
    private static final String LOTTO_WINNING_NUMBER_SPLIT_KEYWORD = ",";

    private Lotto winningLotto;

    public WinningLotto(String winningNumbers) {
        this.winningLotto = convertToLotto(winningNumbers);
    }

    public Lotto getWinningLotto() {
        return this.winningLotto;
    }

    public int getMatchedCount(Lotto lotto) {
        int matchedCount = 0;
        for (LottoNumber lottoNumber : lotto.getLottoNumbers()) {
            matchedCount += CountingMatched(lottoNumber);
        }
        return matchedCount;
    }

    private int CountingMatched(LottoNumber lottoNumber) {
        if (this.winningLotto.getLottoNumbers().stream()
                .anyMatch(l -> l.getLottoNumber() == lottoNumber.getLottoNumber())) {
            return 1;
        }
        return 0;
    }

    private Lotto convertToLotto(String winningNumbers) {
        Set<LottoNumber> lottoNumbers = new LinkedHashSet<>();
        for (String s : winningNumbers.split(LOTTO_WINNING_NUMBER_SPLIT_KEYWORD)) {
            lottoNumbers.add(new LottoNumber(s.trim()));
        }
        return new Lotto(lottoNumbers);
    }
}
