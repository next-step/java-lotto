package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class MatchTest {
    @ParameterizedTest
    @CsvSource(value = {"NONE:0", "THREE:5000", "FOUR:50000", "FIVE:1500000", "SIX:2000000000"}, delimiter = ':')
    void getMoney(String name, long money) {
        assertThat(Match.valueOf(name).getMoney()).isEqualTo(new Money(money));
    }
}