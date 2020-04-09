package lotto.domain.rank;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class WinningLotto {
    private final List<Integer> winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        validate(lotto, bonusNumber);
        this.winningNumbers = lotto.toIntValues();
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(List<Integer> winningNumbers, int bonusNumber) {
        return new WinningLotto(Lotto.of(winningNumbers), LottoNumber.of(bonusNumber));
    }

    public List<LottoRank> matchLotteries(List<Lotto> lotteries) {
        return lotteries.stream()
                .map(myLotto -> myLotto.checkRank(winningNumbers, bonusNumber))
                .collect(toList());
    }

    private void validate(Lotto lotto, LottoNumber bonusNumber) {
        if (isBeingBonus(lotto, bonusNumber)) {
            throw new BonusNumberDuplicateException();
        }
    }

    private boolean isBeingBonus(Lotto lotto, LottoNumber bonusNumber) {
        return lotto.toIntValues()
                .stream()
                .anyMatch(e -> e == bonusNumber.intValue());
    }
}
