package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.Arrays;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class RewardTest {


    @DisplayName("로또 당첨횟수 확인 테스트")
    @ParameterizedTest
    @EnumSource(value = PrizeInformation.class, names = {"THIRD", "SECOND"})
    public void prizeCountTest(PrizeInformation prizeInformation){
        //Given
        Reward reward = new Reward(Arrays.asList(prizeInformation, prizeInformation, prizeInformation));

        //When
        Map<PrizeInformation, Integer> result = reward.getRewardResult();

        //Then
        assertThat(result.get(prizeInformation)).isEqualTo(3);
    }

    @DisplayName("수익률 테스트")
    @Test
    public void earningTest(){
        //Given
        int totalReward = PrizeInformation.FIFTH.getPrizePrice();
        int purchasePrice = 14_000;
        float expectRate = (float) totalReward / purchasePrice;

        //When
        Reward reward = new Reward(Arrays.asList(PrizeInformation.FIFTH));
        reward.getRewardResult();
        float rate = reward.earningRate(14_000);

        //Then
        assertThat(rate).isEqualTo(expectRate);


    }
}
