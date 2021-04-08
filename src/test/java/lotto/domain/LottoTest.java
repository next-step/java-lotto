package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.domain.Lotto.LOTTO_SIZE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoTest {

    @Test
    @DisplayName("로또 생성 테스트")
    void validate_size() {
        assertThat(new Lotto().countSize()).isEqualTo(LOTTO_SIZE);
    }

    @Test
    @DisplayName("로또 유효성 테스트")
    void validate() {
        assertAll(
                () -> assertThatIllegalArgumentException().isThrownBy(() -> Lotto.of(-1, 2, 3, 4, 5, 6)),
                () -> assertThatIllegalArgumentException().isThrownBy(() -> Lotto.of(0, 2, 3, 4, 5, 6)),
                () -> assertThatIllegalArgumentException().isThrownBy(() -> Lotto.of(41, 42, 43, 44, 45, 46)),
                () -> assertThatIllegalArgumentException().isThrownBy(() -> Lotto.of(1, 2, 3, 4, 5))
        );
    }
}
