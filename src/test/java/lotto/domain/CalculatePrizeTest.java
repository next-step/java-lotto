package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

class CalculatePrizeTest {

    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @MethodSource("lottoMatchingCountData")
    @DisplayName("1, 3, 4, 5, 낙첨 테스트")
    void calculatePrizeOfMatchingCount(int num, CalculatePrize expected) {
        CalculatePrize calculatePrize = CalculatePrize.of(num);
        assertThat(calculatePrize).isEqualTo(expected);
    }

    static Stream<Arguments> lottoMatchingCountData() {
        return Stream.of(
            Arguments.of(0, CalculatePrize.MISS),
            Arguments.of(1, CalculatePrize.MISS),
            Arguments.of(2, CalculatePrize.MISS),
            Arguments.of(3, CalculatePrize.FIFTH),
            Arguments.of(4, CalculatePrize.FOURTH),
            Arguments.of(6, CalculatePrize.FIRST)
        );
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