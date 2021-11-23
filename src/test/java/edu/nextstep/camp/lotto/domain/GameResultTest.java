package edu.nextstep.camp.lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class GameResultTest {
    @ParameterizedTest(name = "total prize: {arguments}")
    @CsvSource(value = {"0,0,0,0", "1,0,0,0", "0,1,0,0", "0,0,1,0", "0,0,0,1"}, delimiter = ',')
    public void create(int first, int second, int third, int fourth) {
        assertThat(GameResult.of(first, second, third, fourth))
                .isEqualTo(GameResult.of(first, second, third, fourth));
        assertThat(GameResult.of(first, second, third, fourth).firstPlace()).isEqualTo(first);
        assertThat(GameResult.of(first, second, third, fourth).secondPlace()).isEqualTo(second);
        assertThat(GameResult.of(first, second, third, fourth).thirdPlace()).isEqualTo(third);
        assertThat(GameResult.of(first, second, third, fourth).fourthPlace()).isEqualTo(fourth);
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
