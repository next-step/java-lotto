package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.domain.LottoTicket;
import step2.domain.LottoTickets;
import step2.domain.Rank;
import step2.domain.Winner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerTest {
    LottoTickets lottoTickets = new LottoTickets();

    List<Integer> winnerNums = Arrays.asList(1, 2, 3, 4, 5, 6);

    @DisplayName("3개 일치")
    @Test
    void matchNumbersThreeTest() {
        assertThat(lottoTickets.matchNumber(Arrays.asList(1, 2, 3, 10, 11, 12), winnerNums)).isEqualTo(3);
    }

    @DisplayName("4개 일치")
    @Test
    void matchNumbersFourTest() {
        assertThat(lottoTickets.matchNumber(Arrays.asList(1, 2, 3, 4, 11, 12), winnerNums)).isEqualTo(4);
    }

    @DisplayName("5개 일치")
    @Test
    void matchNumbersFiveTest() {
        assertThat(lottoTickets.matchNumber(Arrays.asList(1, 2, 3, 4, 5, 12), winnerNums)).isEqualTo(5);
    }

    @DisplayName("6개 일치")
    @Test
    void matchNumbersSixTest() {
        assertThat(lottoTickets.matchNumber(Arrays.asList(1, 2, 3, 4, 5, 6), winnerNums)).isEqualTo(6);
    }

    @DisplayName("상금 일치")
    @ParameterizedTest
    @CsvSource(value = {"3:5000", "4:50000", "5:1500000", "6:2000000000"}, delimiter = ':')
    void getRewardTest(int matchCount, int reward) {
        assertThat(Rank.getReward(matchCount)).isEqualTo(reward);
    }
}
