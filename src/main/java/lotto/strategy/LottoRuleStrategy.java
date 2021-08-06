package lotto.strategy;

import lotto.model.Lotto;
import lotto.model.LottoNumber;

import java.util.HashSet;
import java.util.Set;

import static java.util.stream.IntStream.rangeClosed;
import static lotto.model.LottoNumber.MAX_OF_LOTTO_NUMBER;
import static lotto.model.LottoNumber.MIN_OF_LOTTO_NUMBER;

public abstract class LottoRuleStrategy {
    protected static final Set<LottoNumber> LOTTO_NUMBERS_RANGE = new HashSet<>();

    static {
        rangeClosed(MIN_OF_LOTTO_NUMBER, MAX_OF_LOTTO_NUMBER)
                .mapToObj(LottoNumber::from)
                .forEach(LOTTO_NUMBERS_RANGE::add);
    }

    abstract public Lotto ticketing();
}
