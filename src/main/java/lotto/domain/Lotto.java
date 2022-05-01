package lotto.domain;

import lotto.constant.MatchResult;
import lotto.exception.InvalidLottoNumberCount;

import java.util.List;
import java.util.Optional;

public class Lotto {

    public static final int LOTTO_NUMBER_COUNT = 6;

    private MatchResult matchResult;
    private final LottoNumbers lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        this(new LottoNumbers(lottoNumbers));
    }

    public Lotto(LottoNumbers lottoNumbers) {
        if (!lottoNumbers.isSameCount(LOTTO_NUMBER_COUNT)) {
            throw new InvalidLottoNumberCount();
        }
        this.lottoNumbers = lottoNumbers;
    }

    public void confirm(List<LottoNumber> winningNumbers) {
        int matchCount = lottoNumbers.matchCount(winningNumbers);
        this.matchResult = MatchResult.findByMatchCount(matchCount);
    }

    public Optional<MatchResult> findMatchResult() {
        return Optional.ofNullable(matchResult);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
