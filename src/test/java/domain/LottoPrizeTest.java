package domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static domain.LottoPrize.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoPrizeTest {

    @ParameterizedTest
    @CsvSource(value = {"3:FOURTH_PRIZE", "4:THIRD_PRIZE", "5:SECOND_PRIZE", "6:FIRST_PRIZE"}, delimiter = ':')
    void ofTest(int number, LottoPrize lottoPrize) {
        assertThat(LottoPrize.of(number)).isEqualTo(lottoPrize);
    }

    @Test
    void getPrizeValueTest() {
        assertThat(FIRST_PRIZE.getPrizeValue()).isEqualTo(2_000_000_000L);
        assertThat(SECOND_PRIZE.getPrizeValue()).isEqualTo(1_500_000L);
        assertThat(THIRD_PRIZE.getPrizeValue()).isEqualTo(50_000L);
        assertThat(FOURTH_PRIZE.getPrizeValue()).isEqualTo(5_000L);
    }
}
