package kr.heesu.lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class WinningNumbersTest {

    @Test
    void winningNumbers_test() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6);
        WinningNumbers numbers = WinningNumbers.of(integers);
        assertThat(numbers.getWinningNumbers().size()).isEqualTo(integers.size());

        assertThatThrownBy(() -> WinningNumbers.of(Arrays.asList(1, 2, 3, 4))).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> WinningNumbers.of(Arrays.asList(-1, 2, 3, 60, 0, 2))).isInstanceOf(IllegalArgumentException.class);
    }
}