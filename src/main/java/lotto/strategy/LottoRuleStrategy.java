package lotto.strategy;

import lotto.model.Lotto;
import lotto.model.LottoNumber;

import java.util.Collections;
import java.util.Set;

import static java.util.stream.Collectors.toSet;
import static java.util.stream.IntStream.rangeClosed;
import static lotto.model.LottoNumber.MAX_OF_LOTTO_NUMBER;
import static lotto.model.LottoNumber.MIN_OF_LOTTO_NUMBER;

public abstract class LottoRuleStrategy {
    protected static final Set<LottoNumber> LOTTO_NUMBERS_RANGE = Collections.unmodifiableSet(rangeClosed(MIN_OF_LOTTO_NUMBER, MAX_OF_LOTTO_NUMBER)
                                                                                                      .mapToObj(LottoNumber::from)
                                                                                                      .collect(toSet()));

    abstract public Lotto ticketing();
}
