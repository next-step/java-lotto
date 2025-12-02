package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class WinningLottoTest {

    @Test
    @DisplayName("보너스 번호는 당첨번호와 달라양한다")
    void bonusNumberCheck_duplicate() {
        assertThatThrownBy(() -> new WinningLotto(new Lotto(1, 2, 3, 4, 5, 6), 6)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호는 1부터 45 사이어야 한다")
    void bonusNumberCheck_range() {
        assertThatThrownBy(() -> new WinningLotto(new Lotto(1, 2, 3, 4, 5, 6), 50)).isInstanceOf(IllegalArgumentException.class);
    }


}