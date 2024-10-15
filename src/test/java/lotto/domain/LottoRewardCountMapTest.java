package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRewardCountMapTest {
    @Test
    @DisplayName("getRewardCount는 LottoReward에 대응되는 count를 반환합니다.")
    void getRewardCountTest() {
        Map<LottoReward, Integer> rewardCountMapValue = new HashMap<>();
        int count = 2;
        rewardCountMapValue.put(LottoReward.SECOND_PLACE, count);
        LottoRewardCountMap rewardCountMap = LottoRewardCountMap.valueOf(rewardCountMapValue);
        int rewardCount = rewardCountMap.getRewardCount(LottoReward.SECOND_PLACE);
        assertThat(rewardCount).isEqualTo(count);
    }

    @Test
    @DisplayName("getTotalRewar는 전체 reward 합을 반환합니다. ")
    void getTotalRewardTest() {
        Map<LottoReward, Integer> rewardCountMapValue = new HashMap<>();
        int thirdPlaceCount = 1;
        rewardCountMapValue.put(LottoReward.THIRD_PLACE, thirdPlaceCount);

        int secondPlaceCount = 2;
        rewardCountMapValue.put(LottoReward.SECOND_PLACE, secondPlaceCount);

        int expectedTotalReward = thirdPlaceCount * LottoReward.THIRD_PLACE.getReward() + secondPlaceCount * LottoReward.SECOND_PLACE.getReward();
        LottoRewardCountMap rewardCountMap = LottoRewardCountMap.valueOf(rewardCountMapValue);
        int totalReward = rewardCountMap.getTotalReward();
        assertThat(totalReward).isEqualTo(expectedTotalReward);
    }
}
