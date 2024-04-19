package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoPrize;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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

        assertThrows(IllegalArgumentException.class, () -> Lotto.parse(input));
    }

    @Test
    void matchCount() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> generateNumbers = List.of(1, 2, 3, 4, 5, 7);

        int result = Lotto.matchCount(winningNumbers, generateNumbers);
        assertThat(result).isEqualTo(5);
    }

    @Test
    void calculatePrizeCounts() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<List<Integer>> tickets = Arrays.asList(
                List.of(1, 2, 3, 4, 5, 6),   // 6 matches
                List.of(1, 2, 3, 7, 8, 9),   // 3 matches
                List.of(10, 11, 12, 13, 14, 15) // 0 matches
        );

        Map<Integer, Integer> prizeCounts = Lotto.calculatePrizeCounts(winningNumbers, tickets);

        assertEquals(1, prizeCounts.getOrDefault(6, 0));
        assertEquals(1, prizeCounts.getOrDefault(3, 0));
        assertFalse(prizeCounts.containsKey(0));
    }

    @Test
    void returnRate() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<List<Integer>> purchasedTickets = Arrays.asList(            List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(23, 25, 33, 36, 39, 41),
                List.of(1, 3, 5, 14, 22, 45),
                List.of(5, 9, 38, 41, 43, 44),
                List.of(2, 8, 9, 18, 19, 21),
                List.of(13, 14, 18, 21, 23, 35),
                List.of(17, 21, 29, 37, 42, 45),
                List.of(3, 8, 27, 30, 35, 44)
        );


        int ticketPrice = 1000;
        int totalWinnings = purchasedTickets.stream()
                .mapToInt(ticket -> LottoPrize.calculatePrize(Lotto.matchCount(winningNumbers, ticket)))
                .sum();
        int totalInvestment = purchasedTickets.size() * ticketPrice;

        double calculatedReturnRate = (double) totalWinnings / totalInvestment;

        assertEquals(0.35, calculatedReturnRate, 0.01);
    }
}
