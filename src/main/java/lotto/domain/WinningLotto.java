package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningLotto {

    private static final int LOTTO_COUNT = 6;

    private final Set<LottoNumber> numbers;
    private final LottoNumber bonusNumber;

    public WinningLotto(List<Integer> numbers, Integer bonusNumber) {
        this.numbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
        this.bonusNumber = new LottoNumber(bonusNumber);
        validLottoNumberCount(this.numbers);
        validBonusNumber(this.numbers, this.bonusNumber);
    }

    private void validLottoNumberCount(Set<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException("로또 번호는 6개입니다.");
        }
    }

    private void validBonusNumber(Set<LottoNumber> numbers, LottoNumber bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 볼의 숫자는 6개의 로또 번호와 달라야 합니다.");
        }
    }

    public Set<LottoNumber> getNumbers() {
        return Collections.unmodifiableSet(numbers);
    }

    boolean isMatchBonus(Lotto lotto) {
        return lotto.getNumbers().contains(this.bonusNumber);
    }

}

