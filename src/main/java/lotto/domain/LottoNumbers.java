package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {

    public static final int MATCH_COUNT_FIVE = 5;
    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(final List<LottoNumber> lottoNumbers) {

        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumber> getLottoNumbers() {

        return Collections.unmodifiableList(this.lottoNumbers);
    }

    public List<WinningPrize> match(final WinningLottoNumber winningLottoNumber) {

        List<WinningPrize> result = new ArrayList<>();
        for (LottoNumber lottoNumber : lottoNumbers) {
            final int countOfMatch = lottoNumber.match(winningLottoNumber);
            final boolean bonusResult = canMatch(winningLottoNumber, lottoNumber, countOfMatch);
            final WinningPrize winningPrize = WinningPrize.from(countOfMatch, bonusResult);
            result.add(winningPrize);
        }
        return result;
    }

    private boolean canMatch(final WinningLottoNumber winningLottoNumber, final LottoNumber lottoNumber, final int countOfMatch) {

        if (countOfMatch == MATCH_COUNT_FIVE) {
            return lottoNumber.matchBonus(winningLottoNumber);
        }
        return false;
    }
}
