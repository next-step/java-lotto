package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.util.InputUtil.convertToInt;
import static lotto.util.InputUtil.split;

public class LottoGenerator {
    public static final int BASE_INDEX = 0;
    private static List<LottoNumber> baseNumbers =
            IntStream.range(LottoNumber.MINIMUM_NUMBER, LottoNumber.MAXIMUM_NUMBER)
                    .mapToObj(LottoNumber::valueOf)
                    .collect(Collectors.toList());

    public static LottoGenerator getInstance() {
        return new LottoGenerator();
    }

    public Lotto generateLotto() {
        Collections.shuffle(baseNumbers);
        return new Lotto(new HashSet<>(baseNumbers.subList(BASE_INDEX, Lotto.SIZE_LIMIT)));
    }

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
