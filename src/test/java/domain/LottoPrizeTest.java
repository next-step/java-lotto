package domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoPrizeTest {

    @Test
    void isWonTest() {
        assertThat(LottoPrize.FIRST_PRIZE.isWon(6L)).isTrue();
        assertThat(LottoPrize.SECOND_PRIZE.isWon(5L)).isTrue();
        assertThat(LottoPrize.THIRD_PRIZE.isWon(4L)).isTrue();
        assertThat(LottoPrize.FOURTH_PRIZE.isWon(3L)).isTrue();
    }

    @Test
    void getPrizeValueTest() {
        assertThat(LottoPrize.FIRST_PRIZE.getPrizeValue()).isEqualTo(2000000000L);
        assertThat(LottoPrize.SECOND_PRIZE.getPrizeValue()).isEqualTo(1500000L);
        assertThat(LottoPrize.THIRD_PRIZE.getPrizeValue()).isEqualTo(50000L);
        assertThat(LottoPrize.FOURTH_PRIZE.getPrizeValue()).isEqualTo(5000L);
    }
}
