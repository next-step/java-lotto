package lotto.entity;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class WinningNumbersTest {

    @Test
    void 당첨_숫자_리스트_반환() {
        List<Integer> numbers = WinningNumbers.numbers("1, 2, 3, 4, 5, 6");

        assertAll(
                () -> assertThat(numbers).hasSize(6),
                () -> assertThat(numbers).contains(1, 2, 3, 4, 5, 6)
        );
    }

    @Test
    void 당첨_숫자_리스트_중복_예외() {
        assertThatThrownBy(() -> WinningNumbers.numbers("1, 2, 3, 4, 4, 6")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_숫자_리스트_크기_예외() {
        assertThatThrownBy(() -> WinningNumbers.numbers("1, 2, 3, 4, 5, 6, 7")).isInstanceOf(IllegalArgumentException.class);
    }

}
