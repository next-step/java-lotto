package lotto.model;

import lotto.prize.LottoPrize;
import lotto.prize.MatchInformation;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import static java.util.stream.Collectors.toList;

public class WinningLotto {
    private final Set<LottoNumber> winningNumber;
    private final LottoNumber bonusNumber;

    private WinningLotto(final Set<LottoNumber> lottoNumbers, final LottoNumber bonusNumber) {
        this.winningNumber = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto from(final String winningNumber, final String bonusNumber) {
        validateConstructor(winningNumber, bonusNumber);
        return new WinningLotto(LottoNumber.aggregate(winningNumber), LottoNumber.from(bonusNumber));
    }

    private static void validateConstructor(String winningNumber, String bonusNumber) {
        Objects.requireNonNull(winningNumber, "winningNumber must be not null.");
        Objects.requireNonNull(bonusNumber, "lottos must be not null.");
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException("the lotto number and the bonus number overlap.");
        }
    }

    public List<LottoPrize> matchResults(final Lottos lottos) {
        Objects.requireNonNull(lottos, "lottos must be not null.");
        return lottos.stream()
                     .map(this::createMatchInformation)
                     .map(LottoPrize::valueOf)
                     .collect(toList());
    }

    private MatchInformation createMatchInformation(Lotto lotto) {
        return MatchInformation.of(getMatchCount(lotto), isMatchBonus(lotto));
    }

    private int getMatchCount(final Lotto lotto) {
        return lotto.getMatchCount(winningNumber);
    }

    public boolean isMatchBonus(final Lotto lotto) {
        return lotto.isMatchBonus(bonusNumber);
    }

}
