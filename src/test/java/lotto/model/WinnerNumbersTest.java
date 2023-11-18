package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerNumbersTest {

    @Test
    @DisplayName("당첨 번호 중 해당 번호가 있는지 확인")
    void test1() throws Exception {
        WinnerNumbers winnerNumbers = new WinnerNumbers(Set.of(
                new PositiveNumber(1),
                new PositiveNumber(2),
                new PositiveNumber(3),
                new PositiveNumber(4),
                new PositiveNumber(5),
                new PositiveNumber(6)));
        assertThat(winnerNumbers.has(new PositiveNumber(3))).isTrue();
        assertThat(winnerNumbers.has(new PositiveNumber(7))).isFalse();
    }

}