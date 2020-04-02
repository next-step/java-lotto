package study.lotto.domain;

import study.lotto.domain.exception.NoDuplicatedNumberAllowedException;

import java.util.*;

public class LottoWinningNumber {
    private static final String DUPLICATED_BONUS_NUMBER_ERROR_MESSAGE =
            "보너스 번호의 중복은 허용되지 않습니다.";

    private Lotto winningNumbers;
    private LottoNumber bonusNumber;

    public LottoWinningNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new NoDuplicatedNumberAllowedException(
                    DUPLICATED_BONUS_NUMBER_ERROR_MESSAGE);
        }
        this.winningNumbers = new Lotto(winningNumbers);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public int size() {
        return winningNumbers.size();
    }

    public LottoRank rank(Lotto lotto) {
        int matchCount = winningNumbers.matchingCount(lotto);
        boolean matchBonus = lotto.contains(bonusNumber);

        return LottoRank.valueOf(matchCount, matchBonus);
    }
}
