package domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoPrizeTest {

    @ParameterizedTest
    @CsvSource(value = {"3:FIFTH_PRIZE", "4:FOURTH_PRIZE", "5:SECOND_PRIZE", "6:FIRST_PRIZE"}, delimiter = ':')
    void ofTest(int number, LottoPrize lottoPrize) {
        assertThat(LottoPrize.of(number, true)).isEqualTo(lottoPrize);
    }

}
