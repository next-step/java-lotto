package lotto;

import lotto.model.Rank;
import lotto.model.WinningNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class WinningNumbersTest {

    List<Rank> winnerLottoNumbers = new ArrayList<>();
    Rank lottoRank_First = Rank.valueOf(6, false);
    Rank testRank_Second = Rank.valueOf(5, false);
    Rank testRank_Miss = Rank.valueOf(0, false);
    @BeforeEach
    void winnerTestBefore() {
        winnerLottoNumbers.add(lottoRank_First);
        winnerLottoNumbers.add(testRank_Second);
        winnerLottoNumbers.add(testRank_Miss);
    }

    @DisplayName("당첨 리스트 일급 컬렉션 카운트 테스트")
    @ParameterizedTest
    @CsvSource(value = {
            "6:1",
            "5:1",
            "4:0",
            "0:1",},
            delimiter = ':')
    void winnerCountTest(int rank, int matchCount) {
        assertThat(new WinningNumbers(winnerLottoNumbers).getWinnerCount(rank)).isEqualTo(matchCount);
    }

    @DisplayName("당첨 리스트 일급 컬렉션 테스트 당첨")
    @Test
    void winner_total_prize_test() {
        int first_prize = lottoRank_First.getWinningMoney();
        int second_prize = testRank_Second.getWinningMoney();
        int expected = first_prize + second_prize;
        assertThat(new WinningNumbers(winnerLottoNumbers).getTotalPrize()).isEqualTo(expected);
    }


}
