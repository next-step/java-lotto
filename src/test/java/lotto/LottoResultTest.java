package lotto;

import lotto.model.LottoResult;
import lotto.model.Rank;
import lotto.model.RankReward;
import lotto.model.RewardStatus;
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
        List<Rank> rankList = new LottoResult(rewardLottos).getLottoResult();

        assertThat(new RankReward(rankList).getTotalPrize())
                .isEqualTo(Rank.find(new RewardStatus(matchingCount, bonus)).getWinningMoney());
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
