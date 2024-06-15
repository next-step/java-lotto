package lotto.entity;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static lotto.entity.WinningLotto.WINNING_NUMBERS_AND_BONUS_BALLS_CANNOT_OVERLAP;

class WinningLottoTest {
    @Test
    void winningLotto1() {
        var winning = new WinningLotto(new Lotto(Set.of(1, 2, 3, 4, 5, 6)), 7);
    }

    @Test
    @DisplayName("당첨번호, 보너스볼은 중복 불가능")
    void winningLotto2() {
        Assertions.assertThatThrownBy(() -> {
                    new WinningLotto(new Lotto(Set.of(1, 2, 3, 4, 5, 6)), 6);
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(WINNING_NUMBERS_AND_BONUS_BALLS_CANNOT_OVERLAP);
    }
}