package lotto.model.generator;

import lotto.exception.DuplicateLottoNumberException;
import lotto.model.Lotto;
import lotto.model.Number;
import lotto.model.WinningLotto;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class WinningGenerator {

    public static WinningLotto generate(String numbers, int inputOfBonus) {
        List<Number> numberList = Arrays.stream(numbers.trim().split(","))
                .map(Integer::parseInt)
                .map(Number::of)
                .collect(toList());
        Lotto lotto = Lotto.from(numberList);
        Number bonus = Number.of(inputOfBonus);
        duplicateBonusNumber(lotto, bonus);
        return new WinningLotto(lotto, bonus);
    }

    private static void duplicateBonusNumber(Lotto numbers, Number bonus) {
        if (numbers.hasBonusNumber(bonus)) {
            throw new DuplicateLottoNumberException(bonus);
        }
    }
}
