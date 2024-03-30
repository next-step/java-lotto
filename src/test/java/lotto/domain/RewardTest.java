package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RewardTest {

    @DisplayName("당첨번호 갯수에 일치하는 타입이 존재하지 않으면 MISS를 반환한다")
    @ParameterizedTest
    @ValueSource(ints = {0,1,2})
    void fromMatchingCount_miss_test(int matchingCount) {
        assertEquals(Reward.fromMatchingCount(matchingCount),Reward.MISS);
    }

    @DisplayName("당첨번호 갯수에 일치하는 타입이 존재하면 해당 enum을 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"3:THREE", "4:FOUR", "5:FIVE", "6:SIX"}, delimiter = ':')
    void fromMatchingCount_getEnum_test(int matchingCount, String expected) {
        assertEquals(Reward.fromMatchingCount(matchingCount), Reward.valueOf(expected));
    }

    @DisplayName("당첨번호 갯수에 일치하는 타입이 존재하면 당첨금이 있다")
    @ParameterizedTest
    @EnumSource(value = Reward.class, names = {"THREE", "FOUR", "FIVE", "SIX"})
    void getReward_test(Reward reward) {
        int rewardAmount = reward.getReward();
        assertTrue(rewardAmount > 0);
    }

}
