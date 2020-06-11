package lotto;

import lotto.model.LottoResult;
import lotto.model.Rank;
import lotto.model.RewardStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @DisplayName("로또 당첨번호 매칭")
    @ParameterizedTest
    @CsvSource(value = {
            "3:true",
            "4:false",
            "5:true",
            "6:false",},
            delimiter = ':')
    void LOTTO_WINNER_PRIZE_MATCHING_TEST(int matchingCount, boolean bonus) {
        List<RewardStatus> rewardLottos = new ArrayList<>();

        rewardLottos.add(new RewardStatus(matchingCount, bonus));
        LottoResult lottoResult = new LottoResult(rewardLottos);

        assertThat(lottoResult.getTotalPrize())
                .isEqualTo(Rank.find(new RewardStatus(matchingCount, bonus)).getWinningMoney());
    }

    List<RewardStatus> winnerLottoNumbers = new ArrayList<>();
    RewardStatus first = new RewardStatus(6, false);
    RewardStatus second = new RewardStatus(5, true);
    RewardStatus thrid = new RewardStatus(5, false);
    @BeforeEach
    void winnerTestBefore() {
        winnerLottoNumbers.add(first);
        winnerLottoNumbers.add(second);
        winnerLottoNumbers.add(thrid);
        winnerLottoNumbers.add(new RewardStatus(2, false));
        winnerLottoNumbers.add(new RewardStatus(0, false));
    }

    @DisplayName("당첨 리스트 일급 컬렉션 카운트 테스트")
    @ParameterizedTest
    @CsvSource(value = {
            "6,false:1",
            "5,true:1",
            "5,false:1",
            "3,false:0",
            "2,false:2",
            "1,false:2",},
            delimiter = ':')
    void winnerCountTest(String matchCount, int expectedCount) {
        String[] matchArray = matchCount.split(",");
        int cnt = Integer.parseInt(matchArray[0]);
        Boolean bonus = Boolean.valueOf(matchArray[1]);
        assertThat(new LottoResult(winnerLottoNumbers).getWinnerCount(new RewardStatus(cnt, bonus))).isEqualTo(expectedCount);
    }

    @DisplayName("당첨 리스트 일급 컬렉션 테스트 당첨")
    @Test
    void winner_total_prize_test() {
        int expected = Rank.find(first).getWinningMoney()
                + Rank.find(second).getWinningMoney()
                + Rank.find(thrid).getWinningMoney();
        assertThat(new LottoResult(winnerLottoNumbers).getTotalPrize()).isEqualTo(expected);
    }

    @Test
    void RANK_SORT_TEST() {
        List<Rank> rankList =  Arrays.stream(Rank.values())
                                .sorted(Comparator.comparing(Rank::getWinningMoney))
                                .filter(r -> r.getCountOfMatch() >= 3)
                                .collect(Collectors.toList());
        for (Rank rank : rankList) {
            System.out.println(rank.getRewardStatus().getMatchingCount());
        }
    }
}
