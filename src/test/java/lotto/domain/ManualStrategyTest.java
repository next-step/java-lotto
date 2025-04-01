package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ManualStrategyTest {
    @DisplayName("수동 로또를 생성한다.")
    @Test
    void generateTest() {
        // given
        ManualStrategy manualStrategy = new ManualStrategy("1, 2, 3, 4, 5, 6");

        // when
        Lotto lotto = manualStrategy.generate();

        // then
        assertThat(lotto).isNotNull();
    }

    @DisplayName("로또 생성시 중복값 발생하면 예외처리한다.")
    @Test
    void invalidTest() {
        assertThatThrownBy(() -> new ManualStrategy("1, 2, 3, 4, 5, 5").generate()).isInstanceOf(
                        IllegalArgumentException.class)
                .hasMessage("duplicate number is not allowed");
    }

    @DisplayName("로또 생성 시 길이가 6이 아닌 경우 예외가 발생한다.")
    @Test
    void checkValidLengthTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> new ManualStrategy("1, 2, 3, 4, 5, 6, 7").generate())
                .withMessage("lotto size is not 6");
    }
}
