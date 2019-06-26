package lotto.model.generator;

import lotto.exception.DuplicateLottoNumberException;
import lotto.model.Lotto;
import lotto.model.Number;
import lotto.model.WinningLotto;
import lotto.utils.StringUtils;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class WinningGenerator {

    public static WinningLotto generate(String numbers, int inputOfBonus) {
        Lotto lotto = Lotto.from(StringUtils.parseNumbers(numbers));
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
