package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class RewardTest {


    @Test
    public void getRewardResult(){
        //Given
        Reward reward = new Reward(Arrays.asList(PrizeInformation.THIRD,PrizeInformation.SECOND));

        //When
        Map<PrizeInformation, Integer> result = reward.getRewardResult();

        //Then
        assertThat(result).isNotNull();
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
