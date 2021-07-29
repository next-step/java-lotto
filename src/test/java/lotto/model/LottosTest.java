package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottosTest {
    private Lottos lottos;

    @BeforeEach
    void setUp() {
        lottos = Lottos.from(List.of(
                                     Lotto.from(List.of(1, 2, 3, 4, 5, 6)),
                                     Lotto.from(List.of(1, 2, 3, 4, 5, 6)),
                                     Lotto.from(List.of(1, 2, 3, 4, 5, 6)))
                            );
    }

    @Test
    @DisplayName("가지고 있는 로또를 모두 긁고 자신을 반환한다")
    void scratch() {
        Lottos scratchLottos = lottos.scratch(WinningNumber.from("1, 2, 3, 4, 5, 6"));
        Assertions.assertThat(lottos).isEqualTo(scratchLottos);
    }

    @Test
    @DisplayName("지난 주 당첨 번호가 6자리가 아닌 경우 예외를 던진다")
    void scratchFalse() {
        Assertions.assertThatThrownBy(() -> lottos.scratch(WinningNumber.from("1, 2, 3, 4, 5, 6, 7")))
                  .isInstanceOf(IllegalArgumentException.class)
                  .hasMessage("there must be 6 numbers.");
    }

    @Test
    @DisplayName("로또에 대한 스트림을 반환한다")
    void stream() {
        Assertions.assertThat(lottos.stream()).isNotNull();
    }

    @Test
    @DisplayName("투 스트링이 로또 번호를 반환하는지 확인한다")
    void testToString() {
        Assertions.assertThat(lottos.toString()).contains("[1, 2, 3, 4, 5, 6]");
    }
}
