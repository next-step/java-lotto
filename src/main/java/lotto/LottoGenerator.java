package lotto;

import java.util.Set;
import java.util.stream.Collectors;

import static lotto.util.InputUtil.convertToInt;
import static lotto.util.InputUtil.split;

public abstract class LottoGenerator {
    int BASE_INDEX = 0;

    abstract Lotto generateLotto();

    public Lotto generateLotto(final String numbers) {
        return new Lotto(convertToLottoNumber(convertToInt(split(numbers))));
    }

    public Set<LottoNumber> convertToLottoNumber(Set<Integer> numbers) {
        return numbers.stream().map(LottoNumber::valueOf).collect(Collectors.toSet());
    }

    public WinningLotto generateWinningLotto(final String numbers, int bonusBall) {
        return new WinningLotto(generateLotto(numbers), LottoNumber.valueOf(bonusBall));
    }
}
