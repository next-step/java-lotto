package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RankTest {

    private Rank rank;

    @ParameterizedTest
    @CsvSource({"6, false, 2000000000", "5, true, 30000000", "5, false, 1500000", "4, false, 50000", "3, false, 5000", "0, false, 0"})
    void winner_gets_amount(int input, boolean matchBonus, BigDecimal expected) {
        BigDecimal amount = rank.getRank(input, matchBonus).getAmount();
        assertEquals(expected, amount);
    }
}
