package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLotto {

    public static final String DUPLICATED_BONUS_NUMBER_ERROR = "보너스 번호는 중복될 수 없습니다.";

    private Lotto lotto;
    private LottoNumber bonusNumber;

    public WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        assertUniqueBonusNumber(lotto.getLottoNumbers(), bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getNumbers() {
        return lotto.getLottoNumbers();
    }

    public boolean matchBonusNumber(List<Integer> numbers) {
        return bonusNumber.hasMatchedNumber(numbers);
    }

    private void assertUniqueBonusNumber(List<Integer> numbers, LottoNumber bonusNumber) {
        Set<Integer> uniqueNumberSet = new HashSet<>(numbers);

        if (uniqueNumberSet.contains(bonusNumber.getValue())) {
            throw new IllegalArgumentException(DUPLICATED_BONUS_NUMBER_ERROR);
        }
    }
}
