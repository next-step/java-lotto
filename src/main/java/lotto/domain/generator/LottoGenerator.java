package lotto.domain.generator;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;

import java.util.Set;
import java.util.stream.Collectors;

import static lotto.util.InputUtil.convertToInt;
import static lotto.util.InputUtil.split2;


public interface LottoGenerator {
    int BASE_INDEX = 0;

    static Set<LottoNumber> convertToLottoNumber(Set<Integer> numbers) {
        return numbers.stream().map(LottoNumber::valueOf).collect(Collectors.toSet());
    }

    static Lotto generateLotto(final String numbers) {
        return new Lotto(convertToLottoNumber(convertToInt(split2(numbers))));
    }

    static WinningLotto generateWinningLotto(final String numbers, int bonusBall) {
        return new WinningLotto(generateLotto(numbers), LottoNumber.valueOf(bonusBall));
    }

    Lottos generateLottos();
}
