package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {
    @Test
    @DisplayName("보너스 번호가 당첨 번호에 이미 있는 경우")
    void createWinningLotto_bonusNumberAlreadyInNumbers() {
        Numbers numbers = Numbers.builder().add(6).add(7).build();
        Number bonus = new Number(6);

        assertThatThrownBy(() ->
                new WinningLotto(numbers, bonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("bonus number already in winning numbers");
    }
}