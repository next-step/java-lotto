package autolotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultsTest {
    private Results results;

    @BeforeEach
    void setUp() {
        results = new Results();
        results.initialize();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "3:3:5000",
            "4:4:50000"
    }, delimiter = ':')
    void matchCountGiven_ReturnResult(int expect, int actual, int prize) {
        assertThat(results.find(expect)).isEqualTo(Optional.of(new Result(actual, prize)));
    }

    @Test
    void ReturnPrize() {
        assertThat(results.prize()).isEqualTo(0);
    }
}
