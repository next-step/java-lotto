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
        Set<Integer> numbers = new HashSet<>(Set.of(1, 2, 3, 4, 5, 6));
        WinnerNumbers winnerNumbers = new WinnerNumbers(numbers);
        assertThat(winnerNumbers.has(3)).isTrue();
        assertThat(winnerNumbers.has(7)).isFalse();
    }

}