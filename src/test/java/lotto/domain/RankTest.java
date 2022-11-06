package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RankTest {

    private Rank rank;

    @ParameterizedTest
    @CsvSource({"6, 45, 2000000000", "5, 45, 1500000", "4, 45, 50000", "3, 45, 5000", "0, 45, 0"})
    void winner_gets_amount(int input, Integer number, BigDecimal expected) {
        BigDecimal amount = rank.getRank(input, number).getAmount();
        assertEquals(expected, amount);
    }
}
