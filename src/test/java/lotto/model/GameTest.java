package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameTest {

    @Test
    @DisplayName("1000원 미만 입력 시 예외처리")
    void buyException() {
        assertThatThrownBy(() -> Game.buyingLotto(999)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동 로또 구매")
    void buyLotto() {
        assertThat(Game.buyingLotto(14000).getLottoList()).hasSize(14);
    }
}