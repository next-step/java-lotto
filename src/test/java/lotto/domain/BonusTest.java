package lotto.domain;

import static lotto.domain.Bonus.BONUS_NUMBER_OVERLAPPING_EXCEPTION;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusTest {

    @Test
    @DisplayName("당첨 로또와 보너스 숫자가 겹치면 예외를 던진다.")
    void create_bonus_exception() {
        // given
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);

        // when // then
        Assertions.assertThatThrownBy(() -> new Bonus(1, lotto))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(BONUS_NUMBER_OVERLAPPING_EXCEPTION);
    }
}
