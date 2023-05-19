package lottoauto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class WinningLotto {

    private final List<LottoNumber> winningLotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(List<LottoNumber> winningLotto, LottoNumber bonusNumber) {
        winningLottoValidation(winningLotto, bonusNumber);
        winningLotto.add(bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void winningLottoValidation(List<LottoNumber> winningNumber, LottoNumber bonusNumber) {

        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 숫자가 당첨 숫자에 포함되어 있습니다.");
        }

        if (!Lotto.LOTTO_NUMBER_RANGE.contains(bonusNumber.getNumber())) {
            throw new IllegalArgumentException("보너스 숫자는 1~45까지의 숫자를 입력해야 합니다.");
        }
    }

    public WinningReward compare(Lotto lotto) {
        boolean existBonus = lotto.contains(bonusNumber);
        List<LottoNumber> matchNumbers = lotto.getNumbers().stream()
                .filter(number -> winningLotto.stream()
                        .anyMatch(Predicate.isEqual(number)))
                .collect(Collectors.toList());

        if (matchNumbers.size() == WinningReward.MATCH_5.getMatchCount()) {
            return calculateBonus(existBonus);
        }

        return WinningReward.findRewardByMatchCount(matchNumbers.size());

    }

    public LottoResult result(Lottos lottos) {
        List<WinningReward> matchCount = new ArrayList<>();
        for (Lotto lotto : lottos.getLottos()) {
            matchCount.add(compare(lotto));
        }
        return new LottoResult(matchCount);
    }

    private WinningReward calculateBonus(boolean existBonus) {
        if (!existBonus) {
            return WinningReward.MATCH_5;
        }

        return WinningReward.MATCH_5_BONUS;
    }


}
