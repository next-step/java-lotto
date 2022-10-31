package Lotto.Lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRewardTest {
    @ParameterizedTest
    @CsvSource(value = {"2,0", "3,5000", "4,50000", "5,1500000", "6,2000000000"}, delimiter = ',')
    @DisplayName("맞춘 숫자에 따른 당첨금 확인")
    public void rewardTest(final Integer matchCount, final Integer rewardMoney) {
        assertThat(LottoReward.valueOfMatchCount(matchCount).getRewardMoney()).isEqualTo(rewardMoney);
    }
}
