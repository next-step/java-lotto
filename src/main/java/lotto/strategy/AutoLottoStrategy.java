package lotto.strategy;

import lotto.model.Lotto;
import lotto.model.LottoNumber;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.shuffle;
import static java.util.stream.IntStream.rangeClosed;
import static lotto.model.LottoNumber.MAX_OF_LOTTO_NUMBER;
import static lotto.model.LottoNumber.MIN_OF_LOTTO_NUMBER;

public class AutoLottoStrategy implements LottoRuleStrategy {
    private static final AutoLottoStrategy AUTO_LOTTO_STRATEGY = new AutoLottoStrategy();
    private static final List<LottoNumber> NUMBERS = new ArrayList<>();

    static {
        rangeClosed(MIN_OF_LOTTO_NUMBER, MAX_OF_LOTTO_NUMBER)
                .mapToObj(LottoNumber::from)
                .forEach(NUMBERS::add);
    }

    private AutoLottoStrategy() {}

    public static AutoLottoStrategy getInstance() {
        return AUTO_LOTTO_STRATEGY;
    }

    @Override
    public Lotto ticketing() {
        shuffle(NUMBERS);
        return Lotto.from(NUMBERS.subList(0, 6));
    }
}
