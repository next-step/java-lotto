package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumbersTest {

    @DisplayName("로또 숫자의 개수가 지정된 개수와 같지 않으면 IllegalArgumentException")
    @Test
    void countOfNumbers() {
        assertThatThrownBy(() -> new LottoNumbers(Stream.of(1, 2, 3, 4, 5).collect(toSet())))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주어진 숫자 한 개와 일치하는 숫자의 개수를 구한다")
    @Test
    void countMatches() {
        LottoNumbers lottoNumbers = new LottoNumbers(Stream.of(1, 2, 3, 4, 5, 6).collect(toSet()));

        long countOfMatches = lottoNumbers.countMatches(1);

        assertThat(countOfMatches).isEqualTo(1);
    }

    @DisplayName("주어진 당첨 번호와 일치하는 숫자의 개수를 구한다")
    @Test
    void countWinningNumberMatches() {
        LottoNumbers lottoNumbers = new LottoNumbers(Stream.of(1, 2, 3, 4, 5, 6).collect(toSet()));
        WinningNumbers winningNumbers = new WinningNumbers(Stream.of(1, 2, 3, 7, 8, 9).collect(toSet()));

        long countOfMatches = lottoNumbers.countMatches(winningNumbers);

        assertThat(countOfMatches).isEqualTo(3);
    }

}
