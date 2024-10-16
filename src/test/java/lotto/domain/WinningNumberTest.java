package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningNumberTest {
    @Test
    void 로또별_당첨_통계() {
        WinningNumber winningNumber = new WinningNumber("1, 2, 3, 4, 5, 6");
        assertThat(winningNumber.countMatches(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))))).isEqualTo(new Matches(List.of(6)));
    }
}