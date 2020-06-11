package lotto;

import lotto.model.Rank;
import lotto.model.RankReward;
import lotto.model.RewardStatus;
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
    Rank lottoRank_First = Rank.getRankByMatchInfo(new RewardStatus(6, false));
    Rank testRank_Second = Rank.getRankByMatchInfo(new RewardStatus(5, true));
    Rank testRank_Third = Rank.getRankByMatchInfo(new RewardStatus(5, false));
    Rank testRank_Miss = Rank.getRankByMatchInfo(new RewardStatus(2, true));
    Rank testRank_Miss2 = Rank.getRankByMatchInfo(new RewardStatus(0, false));
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
            "6,false:1",
            "5,true:1",
            "5,false:1",
            "3,false:0",
            "2,false:0",
            "1,false:0",},
            delimiter = ':')
    void winnerCountTest(String matchCount, int expectedRank) {
        String[] matchArray = matchCount.split(",");
        int cnt = Integer.parseInt(matchArray[0]);
        Boolean bonus = Boolean.valueOf(matchArray[1]);
        assertThat(new RankReward(winnerLottoNumbers).getWinnerCount(new RewardStatus(cnt, bonus))).isEqualTo(expectedRank);
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
