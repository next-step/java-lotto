package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvSource;
import step2.domain.Winner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerTest {
    Winner winner = new Winner();
    List<Integer> winnerNums = Arrays.asList(1, 2, 3, 4, 5, 6);

    @DisplayName("3개 일치")
    @Test
    void matchNumbersThreeTest() {
        assertThat(winner.matchNumber(Arrays.asList(1,2,3,10,11,12), winnerNums)).isEqualTo(3);
    }

    @DisplayName("4개 일치")
    @Test
    void matchNumbersFourTest() {
        assertThat(winner.matchNumber(Arrays.asList(1,2,3,4,11,12), winnerNums)).isEqualTo(4);
    }

    @DisplayName("5개 일치")
    @Test
    void matchNumbersFiveTest() {
        assertThat(winner.matchNumber(Arrays.asList(1,2,3,4,5,12), winnerNums)).isEqualTo(5);
    }

    @DisplayName("6개 일치")
    @Test
    void matchNumbersSixTest() {
        assertThat(winner.matchNumber(Arrays.asList(1,2,3,4,5,6), winnerNums)).isEqualTo(6);
    }

}
