package lotto.strategy;

import lotto.model.Lotto;
import lotto.model.LottoNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static java.util.stream.IntStream.rangeClosed;
import static lotto.model.LottoNumber.MAX_OF_LOTTO_NUMBER;
import static lotto.model.LottoNumber.MIN_OF_LOTTO_NUMBER;

class AutoLottoStrategyTest {
    private static final Set<LottoNumber> LOTTO_NUMBERS_RANGE = new HashSet<>();

    private LottoRuleStrategy strategy;

    static {
        rangeClosed(MIN_OF_LOTTO_NUMBER, MAX_OF_LOTTO_NUMBER)
                .mapToObj(LottoNumber::from)
                .forEach(LOTTO_NUMBERS_RANGE::add);
    }

    @BeforeEach
    void setUp() {
        strategy = AutoLottoStrategy.getInstance();
    }

    @Test
    @DisplayName("자동 로또를 한장 생성한다")
    void ticketing() {
        Lotto lotto = strategy.ticketing(LOTTO_NUMBERS_RANGE);
        Assertions.assertThat(lotto).isNotNull();
        Assertions.assertThat(lotto).isInstanceOf(Lotto.class);
    }
}
