package step2.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersNoTest {

    @ParameterizedTest
    @CsvSource(value = {"1,7,3:3"}, delimiter = ':')
    void getWinnersResultNo(String input, int result) {
        assertThat(WinnersNo.getWinnersResultNo(input).size()).isEqualTo(result);
    }
}
