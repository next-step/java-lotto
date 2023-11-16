package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    @DisplayName("로또 번호가 중복될 시 예외를 반환한다.")
    void validate_duplicate() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 번호가 있습니다.");
    }

    @Test
    @DisplayName("로또 번호가 6개가 아닐 시 예외를 반환한다.")
    void validate_size() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 6개여야 합니다.");
    }

}
