package lotto.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WinningLotto {

    private static final String DUPLICATE_NUMBER_EXCEPTION = "[ERROR] 보너스볼은 중복될 수 없습니다.";

    private final Lotto lotto;
    private final LottoNumber bonus;

    public WinningLotto(Lotto lotto, LottoNumber bonus) {
        validateWinningNumber(lotto, bonus);
        this.lotto = lotto;
        this.bonus = bonus;
    }

    private void validateWinningNumber(Lotto lotto, LottoNumber bonus) {
        List<LottoNumber> numbers = lotto.getLottoNumbers();
        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_EXCEPTION);
        }
    }

    public int getMatchCount(Lotto userLotto) {
        List<LottoNumber> userNumbers = userLotto.getLottoNumbers();
        return (int) userNumbers.stream()
            .filter(userNumber -> isContain(lotto.getLottoNumbers(), userNumber))
            .count();
    }

    public boolean getMatchBonus(Lotto userLotto) {
        List<LottoNumber> userNumbers = userLotto.getLottoNumbers();
        return isContain(userNumbers, bonus);
    }

    private boolean isContain(List<LottoNumber> numbers, LottoNumber target) {
        return numbers.contains(target);
    }
}
