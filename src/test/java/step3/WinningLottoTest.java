package step3;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningLottoTest {

    @Test
    @DisplayName("보너스 번호 중복시 예외")
    void alreadyLottoContainsBonus() {
        assertThatThrownBy(() -> new WinningLotto(Set.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("보너스 번호가 로또 범위를 벗어났을 때 예외")
    @ValueSource(ints = {0, 46})
    void validateBonus(int bonus) {
        assertThatThrownBy(() -> new WinningLotto(Set.of(1, 2, 3, 4, 5, 6), bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
