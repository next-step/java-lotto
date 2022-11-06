package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RankTest {

    private Rank rank;

    @ParameterizedTest
    @CsvSource({"6, 2000000000", "5, 1500000", "4, 50000", "3, 5000", "0, 0"})
    void winner_gets_amount(int input, BigDecimal expected) {
        BigDecimal amount = rank.getRank(input).getAmount();
        assertEquals(expected, amount);
    }
}
