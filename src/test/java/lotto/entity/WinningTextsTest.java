package lotto.entity;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class WinningTextsTest {

    @Test
    void 당첨_숫자_리스트_반환() {
        String[] texts = {"1", "2", "3", "4", "5", "6"};
        Set<Integer> numbers = WinningTexts.numbers(texts);

        assertAll(
                () -> assertThat(numbers).hasSize(6),
                () -> assertThat(numbers).contains(1, 2, 3, 4, 5, 6)
        );
    }

    @Test
    void 당첨_숫자_리스트_중복_예외() {
        String[] texts = {"1", "2", "3", "4", "5", "5"};
        assertThatThrownBy(() -> WinningTexts.numbers(texts)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_숫자_리스트_크기_예외() {
        String[] texts = {"1", "2", "3", "4", "5", "6", "7"};
        assertThatThrownBy(() -> WinningTexts.numbers(texts)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_숫자_범위_넘어가는_예외() {
        String[] texts = {"1", "2", "3", "4", "5", "65"};
        assertThatThrownBy(() -> WinningTexts.numbers(texts)).isInstanceOf(IllegalArgumentException.class);
    }

}
