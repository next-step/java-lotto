package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    void validInput() {
        String input = "1, 2, 3, 4, 5, 6";
        List<Integer> result = List.of(1, 2, 3, 4, 5, 6);

        assertThat(result).hasSize(6);
        assertThat(result.stream().distinct().count()).isEqualTo(6);

        for (int number : result) {
            assertThat(number).isBetween(1, 45);
        }

        assertThat(Lotto.parse(input)).isEqualTo(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "5,12,23,32,38,invalid",    // 잘못된 형식
            "5,12,23,32,38",            // 잘못된 개수
            "0,12,23,32,45,46"          // 잘못된 범위
    })
    void invalidInput(String input) {

        assertThrows(IllegalArgumentException.class, () -> {
            Lotto.parse(input);
        });
    }

    @Test
    void matchCount() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> generateNumbers = List.of(1, 2, 3, 4, 5, 7);

        int result = Lotto.matchCount(winningNumbers, generateNumbers);
        assertThat(result).isEqualTo(5);
    }
}
