package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LastWeekNumbersTest {

    @Test
    void parse() {

        String lastWeekNumbersValue = "1, 2, 3, 4, 5, 6";
        LastWeekNumbers lastWeekNumbers = new LastWeekNumbers(lastWeekNumbersValue);

        assertThat(lastWeekNumbers).isEqualTo(new LastWeekNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }
}