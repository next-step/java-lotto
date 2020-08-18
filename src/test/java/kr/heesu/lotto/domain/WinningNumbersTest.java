package kr.heesu.lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class WinningNumbersTest {

    @Test
    void winningNumbers_creation_test() {
        List<LottoNumber> numbers = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::of)
                .collect(Collectors.toList());

        WinningNumbers winningNumbers = WinningNumbers.of(numbers);

        int actual = winningNumbers.getWinningNumbers().size();
        int expected = numbers.size();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void winningNumbers_validation_test() {
        List<LottoNumber> numbers = Stream.of(1, 2, 3, 4, 5)
                .map(LottoNumber::of)
                .collect(Collectors.toList());

        assertThatThrownBy(() -> WinningNumbers.of(numbers)).isInstanceOf(IllegalArgumentException.class);
    }
}