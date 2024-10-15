package lotto.entity;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class WinningTextTest {
    WinningText winningText = new WinningText();

    @Test
    void 당첨_숫자_리스트_반환() {
        List<Integer> numbers = winningText.numbers("1, 2, 3, 4, 5, 6");

        assertAll(
                () -> assertThat(numbers).hasSize(6),
                () -> assertThat(numbers).contains(1, 2, 3, 4, 5, 6)
        );
    }

    @Test
    void 당첨_숫자_리스트_중복_예외() {
        assertThatThrownBy(() -> winningText.numbers("1, 2, 3, 4, 4, 6")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_숫자_리스트_크기_예외() {
        assertThatThrownBy(() -> winningText.numbers("1, 2, 3, 4, 5, 6, 7")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_숫자_범위_넘어가는_예외() {
        assertThatThrownBy(() -> winningText.numbers("1, 2, 3, 4, 5, 66")).isInstanceOf(IllegalArgumentException.class);
    }

}
