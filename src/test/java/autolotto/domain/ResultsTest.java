package autolotto.domain;

import autolotto.constant.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultsTest {
    private Results results;

    @BeforeEach
    void setUp() {
        results = new Results();
    }

//    @ParameterizedTest
//    @CsvSource(value = {
//            "3:5000",
//            "4:50000"
//    }, delimiter = ':')
//    void ReturnPrize(int numberOfWins, long prize) {
//        results.find(numberOfWins, false).ifPresent(Result::plusWinners);
//
//        assertThat(results.prize()).isEqualTo(prize);
//    }


    @Test
    void rankGiven_ReturnWinners() {
        assertThat(results.plusWinners(Rank.FIRST)).isEqualTo(1);
        assertThat(results.plusWinners(Rank.FIRST)).isEqualTo(2);
        assertThat(results.plusWinners(Rank.SECOND)).isEqualTo(1);
    }
}
