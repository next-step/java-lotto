package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RateTest {

    @ParameterizedTest
    @DisplayName("생성성공")
    @CsvSource(value = {"14000.0:15000.0:1.07", "14000.0:5000.0:0.35", "10000.0:10000.0:1.00"}, delimiter = ':')
    void create(double money, double prizeMoney, double result) {
        Rate rate = Rate.of(money, prizeMoney);
        assertThat(rate.getRate()).isEqualTo(result);
    }

}
