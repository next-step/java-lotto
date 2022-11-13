package step3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusLottoTest {

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

    @Test
    @DisplayName("구매한 로또가 보너스 번호를 가지고 있는지 체크")
    void checkContainsBonus() {
        Lotto test1 = new Lotto(Set.of(1, 2, 3, 4, 5, 6));
        Lotto test2 = new Lotto(Set.of(7, 8, 9, 10, 11, 12));

        WinningLotto bonusLotto = new WinningLotto(Set.of(13, 14, 15, 16, 17, 18), 6);

        assertThat(bonusLotto.checkBonus(test1)).isTrue();
        assertThat(bonusLotto.checkBonus(test2)).isFalse();
    }
}
