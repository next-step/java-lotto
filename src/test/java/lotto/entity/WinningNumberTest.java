package lotto.entity;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumberTest {
    @Test
    void 당첨_숫자_리스트_중복_예외() {
        assertThatThrownBy(() -> new WinningNumbers(Set.of(1, 2, 3, 4, 5, 5))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_숫자_리스트_크기_예외() {
        assertThatThrownBy(() -> new WinningNumbers(Set.of(1, 2, 3, 4, 5, 6, 7))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_숫자_범위_넘어가는_예외() {
        assertThatThrownBy(() -> new WinningNumbers(Set.of(1, 2, 3, 4, 5, 65))).isInstanceOf(IllegalArgumentException.class);
    }
}
