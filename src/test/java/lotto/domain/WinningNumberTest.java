package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumberTest {

    @Test
    @DisplayName("winningNumber 또는 bonusNumber가 null이면 예외((null, 0) => IllegalArgumentException, (0, null) => IllegalArgumentException)")
    void validate_if_not_null() {
        assertThatThrownBy(() -> {
            new WinningNumber(null, 1);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            new WinningNumber(List.of(1, 2, 3), null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 숫자가 로또 넘버 안에 포함되면 예외(([1,2,3,4], 1) => IllegalArgumentException)")
    void bonus_number_should_not_be_in_lotto_numbers() {
        assertThatThrownBy(() -> {
            new WinningNumber(List.of(1, 2, 3), 1);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
