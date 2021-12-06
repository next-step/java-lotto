package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @Test
    void shouldCreateSameObject() {
        Lotto lotto = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto).isEqualTo(Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    void shouldThrowWhenInputNotSixNumbers() {
        assertThatThrownBy(() -> Lotto.from(Arrays.asList(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 숫자는 6자리여야 합니다.");
    }

    @Test
    void shouldThrowWhenInputNotInRange() {
        assertThatThrownBy(() -> Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 숫자는 1 이상 45 이하여야 합니다.");

        assertThatThrownBy(() -> Lotto.from(Arrays.asList(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 숫자는 1 이상 45 이하여야 합니다.");
    }
}
