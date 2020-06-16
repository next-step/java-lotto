package step2;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    void create() {
        Set<Number> numbers = mockLotto();
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.getLotto()).contains(Number.mock(1));
    }

    @Test
    void get_random() {
        Set<Number> numbers = mockLotto();
        Lotto lotto = new Lotto(numbers);
        Set<Number> random = lotto.getRandom();
        assertThat(random.size()).isEqualTo(6);
    }

    @Test
    void lotto_buy() {
        Lotto lotto = Lotto.buy();
        assertThat(lotto.getLotto().size()).isEqualTo(6);
    }

    private Set<Number> mockLotto() {
        Set<Number> numbers = new HashSet<>();
        numbers.add(Number.mock(1));
        numbers.add(Number.mock(2));
        numbers.add(Number.mock(3));
        numbers.add(Number.mock(4));
        numbers.add(Number.mock(5));
        numbers.add(Number.mock(6));
        return numbers;
    }


}
