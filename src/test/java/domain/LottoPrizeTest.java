package domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoPrizeTest {

    @ParameterizedTest
    @CsvSource(value = {"3:FOURTH_PRIZE", "4:THIRD_PRIZE", "5:SECOND_PRIZE", "6:FIRST_PRIZE"}, delimiter = ':')
    void ofTest(int number, LottoPrize lottoPrize) {
        assertThat(LottoPrize.of(number)).isEqualTo(lottoPrize);
    }

    @Test
    void getPrizeValueTest() {
        assertThat(LottoPrize.FIRST_PRIZE.getPrizeValue()).isEqualTo(2000000000L);
        assertThat(LottoPrize.SECOND_PRIZE.getPrizeValue()).isEqualTo(1500000L);
        assertThat(LottoPrize.THIRD_PRIZE.getPrizeValue()).isEqualTo(50000L);
        assertThat(LottoPrize.FOURTH_PRIZE.getPrizeValue()).isEqualTo(5000L);
    }
}
