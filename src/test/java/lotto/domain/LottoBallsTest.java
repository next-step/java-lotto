package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoBallsTest {

    @Test
    @DisplayName("로또 생성")
    void create() {
        assertThat(LottoBalls.of(1, 2, 3, 4, 5, 6)).isNotNull();
    }

    @Test
    @DisplayName("로또 생성 범위 오류")
    void validate_range() {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoBalls.of(51, 52, 53, 54, 55, 56));
    }

    @Test
    @DisplayName("로또 생성 개수 오류")
    void validate_size() {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoBalls.of(1, 2, 3, 4, 5));
    }

}
