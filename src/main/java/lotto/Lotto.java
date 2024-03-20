package lotto;

import java.util.Comparator;
import java.util.List;

public class Lotto {

    public static final int LOTTO_NUMBERS_LIMIT = 6;

    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        validLottoSize(numbers);
        validDuplicatedLottoNumber(numbers);
        numbers.sort(Comparator.comparingInt(LottoNumber::getNumber));
        this.numbers = numbers;
    }

    public int countMatch(WinningLotto winningLotto) {
        return (int) winningLotto.getWinningLotto().stream()
            .filter(numbers::contains)
            .count();
    }

    private void validLottoSize(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_LIMIT) {
            throw new IllegalArgumentException("로또 하나 당 6개의 숫자를 가져야합니다.");
        }
    }

    private void validDuplicatedLottoNumber(List<LottoNumber> numbers) {
        if ((int) numbers.stream().distinct().count() != LOTTO_NUMBERS_LIMIT) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
    }
}
