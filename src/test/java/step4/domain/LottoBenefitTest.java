package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Collections;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoBenefitTest {

    @DisplayName("이익을 정확하게 반환하는지 테스트 - 보너스 제외")
    @ParameterizedTest
    @CsvSource(
            value = {"3:5000:5.0", "4:50000:50.0", "5:1500000:1500.0", "6:2000000000:2000000.0"},
            delimiter = ':')
    void resultBenefitWithoutBonus(int value, Long matchedPrice, double expectedBenefit) {
        Rank rank = Rank.valueOf(value, false);
        Map<Rank, Long> matchResult = Collections.singletonMap(rank, 1L);
        LottoBenefit lottoBenefit =
                new LottoBenefit(1000, matchResult);

        double benefit = lottoBenefit.resultBenefit();

        assertEquals(benefit, expectedBenefit);
    }

    @DisplayName("이익을 정확하게 반환하는지 테스트 - 보너스")
    @Test
    void resultBenefitWithBonus() {
        Rank rank = Rank.valueOf(5, true);
        Map<Rank, Long> matchResult = Collections.singletonMap(rank, 1L);
        LottoBenefit lottoMatchResult =
                new LottoBenefit(1000, matchResult);

        double benefit = lottoMatchResult.resultBenefit();
        double expectedBenefit = 30000.0;

        assertEquals(benefit, expectedBenefit);
    }
}