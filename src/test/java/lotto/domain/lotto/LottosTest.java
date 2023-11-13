package lotto.domain.lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class LottosTest {
    @Test
    @DisplayName("로또를 생성한다. 로또 번호는 1 ~ 45사이의 숫자이어여 하고 총 6자리 이어야 한다. 아니면 예외가 발생한다.")
    public void create() {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

        Assertions.assertThat(
                Lottos.of(10000, () -> list).size()
        ).isEqualTo(10);

        Assertions.assertThatThrownBy(
                () -> Lottos.of(900, () -> list).size()
        ).isInstanceOf(IllegalArgumentException.class);
    }

}