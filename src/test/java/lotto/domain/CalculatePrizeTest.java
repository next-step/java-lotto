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

    @ParameterizedTest(name = "일치하는 번호 갯수 = {0}, 등수 = {1}")
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

    @ParameterizedTest(name = "보너스번호일치 ={0}, 결과 = {1}")
    @MethodSource("bonusNumberMatchedResultData")
    @DisplayName("2, 3등 테스트")
    void getSecondOrThirdPrize(boolean matchingBonusNumber, CalculatePrize resultPrize) {
        CalculatePrize calculatePrize = CalculatePrize.ofSecondOrThird(matchingBonusNumber);
        assertThat(calculatePrize).isEqualTo(resultPrize);
    }

    static Stream<Arguments> bonusNumberMatchedResultData() {
        return Stream.of(
            Arguments.of(true, CalculatePrize.SECOND),
            Arguments.of(false, CalculatePrize.THIRD)
        );
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