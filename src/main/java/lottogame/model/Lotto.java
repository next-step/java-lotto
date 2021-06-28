package lottogame.model;

import java.util.Set;

public class Lotto {

    final static int NUMBER_COUNT_PER_GAME = 6;

    private Set<LottoNumber> numbers;

    public Lotto(final Set<LottoNumber> numbers) {
        validateLottoNumbersSize(numbers);
        this.numbers = numbers;
    }

    private static void validateLottoNumbersSize(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != NUMBER_COUNT_PER_GAME) {
            throw new IllegalArgumentException("로또 번호는 6개여야합니다.");
        }
    }

    public Set<LottoNumber> getNumbers() {
        return numbers;
    }

    public boolean winningLottoNumbersContainsBonusNumber(LottoNumber bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
