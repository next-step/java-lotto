package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    @Test
    void purchase() {
        int result = Lotto.purchase("14000");

        assertThat(result).isEqualTo(14);
    }

    @Test
    void generate() {
        List<Integer> result = Lotto.generate();

        assertThat(result).hasSize(6);
        assertThat(result.stream().distinct().count()).isEqualTo(6);

        for (int number : result) {
            assertThat(number).isBetween(1, 45);
        }
    }

    @Test
    void matchCount() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> generateNumbers = List.of(1, 2, 3, 4, 5, 7);

        int result = Lotto.matchCount(winningNumbers, generateNumbers);
        assertThat(result).isEqualTo(5);
    }
}
