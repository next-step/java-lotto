package lotto.step2.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinnerNumbers {
    private final Lotto winnerLotto;
    private final LottoNumber bonusNumber;

    public WinnerNumbers(final String winnerNumbersText, final int bonusWinnerNumber) {
        final Set<Integer> integers = conventStringToLottoNumberSet(winnerNumbersText);

        this.winnerLotto = new Lotto(integers);

        final LottoNumber bonusLottoNumber = new LottoNumber(bonusWinnerNumber);
        validateBonusWinnerNumber(bonusLottoNumber);

        this.bonusNumber = bonusLottoNumber;
    }

    private void validateBonusWinnerNumber(final LottoNumber bonusLottoNumber) {
        if (this.winnerLotto.contains(bonusLottoNumber)) {
            throw new IllegalArgumentException("bonus winner number must not be in winner nums");
        }
    }

    private static Set<Integer> conventStringToLottoNumberSet(final String winnerNumbersText) {
        return Arrays.stream(winnerNumbersText.split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }

    public Set<LottoNumber> nums() {
        return this.winnerLotto.nums();
    }

    public LottoResults matchLottos(final List<Lotto> lottos) {
        final LottoResults lottoResults = new LottoResults();

        for (final Lotto lotto : lottos) {
            lottoResults.incrementRankCount(lotto.calculateLottoRank(this));
        }

        return lottoResults;
    }
}
