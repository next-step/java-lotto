package lotto.generator;

import lotto.Lotto;
import lotto.LottoNumber;
import lotto.Lottos;
import lotto.WinningLotto;

import java.util.Set;
import java.util.stream.Collectors;

import static lotto.util.InputUtil.convertToInt;
import static lotto.util.InputUtil.split;


public interface LottoGenerator {
    int BASE_INDEX = 0;

    Lottos generateLottos();

    default Set<LottoNumber> convertToLottoNumber(Set<Integer> numbers) {
        return numbers.stream().map(LottoNumber::valueOf).collect(Collectors.toSet());
    }

    default Lotto generateLotto(final String numbers) {
        return new Lotto(convertToLottoNumber(convertToInt(split(numbers))));
    }

    default WinningLotto generateWinningLotto(final String numbers, int bonusBall) {
        return new WinningLotto(generateLotto(numbers), LottoNumber.valueOf(bonusBall));
    }
}
