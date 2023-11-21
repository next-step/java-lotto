package lotto.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    @DisplayName("로또를 생성한다. 로또 번호는 1 ~ 45사이의 숫자이어여 하고 총 6자리 이어야 한다. 아니면 예외가 발생한다.")
    void create() {
        assertThatThrownBy(() -> Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(NullPointerException.class);

        assertThatThrownBy(() -> Lotto.of(Arrays.asList(0, 2, 3, 4, 5, 45)))
                .isInstanceOf(NullPointerException.class);

        assertThatThrownBy(() -> Lotto.of(Arrays.asList(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
