package lotto.entity;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
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

}
