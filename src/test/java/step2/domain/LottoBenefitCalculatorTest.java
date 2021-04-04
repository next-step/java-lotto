package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Collections;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LottoBenefitCalculatorTest {

    @DisplayName("이익을 정확하게 반환하는지 테스트")
    @ParameterizedTest
    @CsvSource(
            value = {"3:5000:5.0", "4:50000:50.0", "5:1500000:1500.0", "6:2000000000:2000000.0"},
            delimiter = ':')
    void resultBenefitMessage(int value, Long matchedPrice, double expectedBenefit) {
        Map<Integer, Long> matchResult = Collections.singletonMap(value, 1L);
        LottoBenefitCalculator lottoMatchResult =
                new LottoBenefitCalculator(1000, matchResult);

        double benefit = lottoMatchResult.resultBenefit();

        assertEquals(benefit, expectedBenefit);
    }

}