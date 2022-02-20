package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lotto {

    private static final int MAX_LOTTO_LENGTH = 6;
    private static final int FIVE_MATCHING = 5;
    private static final String LOTTO_NUMBER_VALIDATION_MESSAGE = "로또는 6개의 숫자입니다";

    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        validateLotto(lottoNumbers);
        Collections.sort(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public Lotto(List<LottoNumber> lottoNumbers, int matchCount, boolean bonusMatch) {
        this(lottoNumbers);
    }

    private void validateLotto(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != MAX_LOTTO_LENGTH) {
            throw new IllegalArgumentException(LOTTO_NUMBER_VALIDATION_MESSAGE);
        }
    }

    public MatchInfo matchLottoWithWinningNumber(WinningNumber winningNumber) {
        int matchCount;
        boolean bonusMatch = false;
        matchCount = winningNumber.findMatchingCount(lottoNumbers);
        if (matchCount == FIVE_MATCHING) {
            bonusMatch = winningNumber.isContainBonusBall(lottoNumbers);
        }
        return new MatchInfo(matchCount, bonusMatch);
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

}
