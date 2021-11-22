package edu.nextstep.camp.lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class GameResultTest {
    @Test
    public void create() {
        assertThat(GameResult.of(0, 0, 0, 0))
                .isEqualTo(GameResult.of(0, 0, 0, 0));
    }

    @ParameterizedTest(name = "create failed: {arguments}")
    @CsvSource(value = {"-1,0,0,0", "0,-1,0,0", "0,0,-1,0", "0,0,0,-1"})
    public void createFailed(int first, int second, int third, int fourth) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> GameResult.of(first, second, third, fourth))
                .withMessageContaining("each amounts must not be negative");
    }

    @ParameterizedTest(name = "total prize: {arguments}")
    @CsvSource(value = {"0,0,0,0,0", "1,0,0,0,2000000000", "0,1,0,0,1500000", "0,0,1,0,50000", "0,0,0,1,5000"}, delimiter = ',')
    public void totalPrize(int first, int second, int third, int fourth, int expected) {
        assertThat(GameResult.of(first, second, third, fourth).totalPrize()).isEqualTo(expected);
    }
}
