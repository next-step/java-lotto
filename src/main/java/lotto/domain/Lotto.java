package lotto.domain;

import java.util.Optional;

public class Lotto {

    private final LottoNumbers lottoNumbers;
    private final int PRICE = 1000;

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = new LottoNumbers(lottoNumbers);
    }

    public Optional<LottoResult> isWinningLotto(Lotto targetLotto) {
        int matchCount = this.lottoNumbers.matchCount(targetLotto.lottoNumbers);

        return LottoResult.findByMatchCount(matchCount);
    }
}
