package step2;

import org.assertj.core.internal.bytebuddy.build.ToStringPlugin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class StatisticTest {

    @BeforeEach
    void setUp() {
        Rank.THIRD.count();
        Rank.FORTH.count();
        Rank.FORTH.count();
    }

    @DisplayName("전체 당첨금의 합계를 구한다")
    @Test
    void sum() {
        int sum = Statistic.sum();
        assertThat(sum).isEqualTo(60000);
    }

    @DisplayName("수익율을 구한다")
    @Test
    void get_yield() {
        Money buy = Money.buy(14000);
        BigDecimal yield = Statistic.getYield(buy);
        assertThat(yield.equals(new BigDecimal(4.00)));
    }

    @DisplayName("당첨 로또와 몇개의 숫자가 맞는지 구한다")
    @Test
    void compare() {
        List<Lotto> lottos = Arrays.asList(
                Lotto.mock(new HashSet<>(mockFirst())),
                Lotto.mock(new HashSet<>(mockSecond()))
        );
        Statistic.compare(lottos,winLotto());
    }

    private Lotto winLotto() {
        Set<Number> numbers = new HashSet<>();
        numbers.add(Number.win(1));
        numbers.add(Number.win(2));
        numbers.add(Number.win(3));
        numbers.add(Number.win(4));
        numbers.add(Number.win(5));
        numbers.add(Number.win(6));
        return Lotto.win(numbers);
    }

    private Set<Number> mockFirst() {
        Set<Number> numbers = new HashSet<>();
        numbers.add(Number.mock(1));
        numbers.add(Number.mock(2));
        numbers.add(Number.mock(3));
        numbers.add(Number.mock(4));
        numbers.add(Number.mock(5));
        numbers.add(Number.mock(6));
        return numbers;
    }

    private Set<Number> mockSecond() {
        Set<Number> numbers = new HashSet<>();
        numbers.add(Number.mock(1));
        numbers.add(Number.mock(2));
        numbers.add(Number.mock(3));
        numbers.add(Number.mock(4));
        numbers.add(Number.mock(5));
        numbers.add(Number.mock(7));
        return numbers;
    }
}
