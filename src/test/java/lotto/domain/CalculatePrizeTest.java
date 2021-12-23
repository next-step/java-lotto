package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class CalculatePrizeTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 6})
    @DisplayName("1, 3, 4, 5, 낙첨 테스트")
    void calculatePrizeOfMatchingCount(int num) {
        CalculatePrize calculatePrize = CalculatePrize.of(num);
        if (num == 0) {
            assertThat(calculatePrize).isEqualTo(CalculatePrize.MISS);
        }
        if (num == 1) {
            assertThat(calculatePrize).isEqualTo(CalculatePrize.MISS);
        }
        if (num == 2) {
            assertThat(calculatePrize).isEqualTo(CalculatePrize.MISS);
        }
        if (num == 3) {
            assertThat(calculatePrize).isEqualTo(CalculatePrize.FIFTH);
        }
        if (num == 4) {
            assertThat(calculatePrize).isEqualTo(CalculatePrize.FOURTH);
        }
        if (num == 6) {
            assertThat(calculatePrize).isEqualTo(CalculatePrize.FIRST);
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    @DisplayName("2, 3등 테스트")
    void getSecondOrThirdPrize(boolean matchingBonusNumber) {
        CalculatePrize calculatePrize = CalculatePrize.ofSecondOrThird(matchingBonusNumber);
        if(matchingBonusNumber){
            assertThat(calculatePrize).isEqualTo(CalculatePrize.SECOND);
        }

        if (!matchingBonusNumber) {
            assertThat(calculatePrize).isEqualTo(CalculatePrize.THIRD);
        }
    }

    @Test
    @DisplayName("당청금계산")
    void calculatePrizeAmount() {
        int matchingCount = 3; //5등
        int prizeCount = 5; //당첨갯수
        CalculatePrize calculatePrize = CalculatePrize.of(matchingCount);
        int prizeAmount = calculatePrize.calculate(prizeCount);
        assertThat(prizeAmount).isEqualTo(25000);
    }
}