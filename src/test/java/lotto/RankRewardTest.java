package lotto;

import lotto.model.Rank;
import lotto.model.RankReward;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class RankRewardTest {

    List<Rank> winnerLottoNumbers = new ArrayList<>();
    Rank lottoRank_First = Rank.valueOf(6, false);
    Rank testRank_Second = Rank.valueOf(5, true);
    Rank testRank_Third = Rank.valueOf(5, false);
    Rank testRank_Miss = Rank.valueOf(2, true);
    Rank testRank_Miss2 = Rank.valueOf(0, false);
    @BeforeEach
    void winnerTestBefore() {
        winnerLottoNumbers.add(lottoRank_First);
        winnerLottoNumbers.add(testRank_Second);
        winnerLottoNumbers.add(testRank_Third);
        winnerLottoNumbers.add(testRank_Miss);
        winnerLottoNumbers.add(testRank_Miss2);
    }

    @DisplayName("당첨 리스트 일급 컬렉션 카운트 테스트")
    @ParameterizedTest
    @CsvSource(value = {
            "1:1",
            "2:1",
            "3:1",
            "4:0",
            "5:0",
            "6:2",},
            delimiter = ':')
    void winnerCountTest(int rank, int matchCount) {
        assertThat(new RankReward(winnerLottoNumbers).getWinnerCount(rank)).isEqualTo(matchCount);
    }

    @DisplayName("당첨 리스트 일급 컬렉션 테스트 당첨")
    @Test
    void winner_total_prize_test() {
        int expected = lottoRank_First.getWinningMoney()
                        + testRank_Second.getWinningMoney()
                        + testRank_Third.getWinningMoney();
        assertThat(new RankReward(winnerLottoNumbers).getTotalPrize()).isEqualTo(expected);
    }


}
