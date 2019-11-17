package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import lotto.domain.LottoTicket;
import lotto.domain.RankEnum;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerTest {
    List<Integer> winnerNums = Arrays.asList(1, 2, 3, 4, 5, 6);

    @DisplayName("3개 일치")
    @Test
    void matchNumbersThreeTest() {
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 10, 11, 12));
        assertThat(lottoTicket.countMatchNumber(winnerNums)).isEqualTo(3);
    }

    @DisplayName("4개 일치")
    @Test
    void matchNumbersFourTest() {
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 11, 12));
        assertThat(lottoTicket.countMatchNumber(winnerNums)).isEqualTo(4);
    }

    @DisplayName("5개 일치")
    @Test
    void matchNumbersFiveTest() {
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 12));
        assertThat(lottoTicket.countMatchNumber(winnerNums)).isEqualTo(5);
    }

    @DisplayName("6개 일치")
    @Test
    void matchNumbersSixTest() {
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lottoTicket.countMatchNumber(winnerNums)).isEqualTo(6);
    }

    @DisplayName("상금 일치")
    @ParameterizedTest
    @CsvSource(value = {"THREE_MATCH:5000", "FOUR_MATCH:50000", "FIVE_MATCH:1500000", "SIX_MATCH:2000000000"}, delimiter = ':')
    void getRewardTest(String nameOfMatch, int reward) {
        assertThat(RankEnum.valueOf(nameOfMatch).getReward()).isEqualTo(reward);
    }
}
