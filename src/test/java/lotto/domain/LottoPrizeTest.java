package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPrizeTest {

    @ParameterizedTest(name = "등수확인 / matchCount: {0}, bonusMatch: {1} / 등수: {2}")
    @CsvSource({
            "6, true, FIRST",
            "6, false, FIRST",
            "5, true, SECOND",
            "5, false, THIRD",
            "4, true, FOURTH",
            "4, false, FOURTH",
            "3, true, FIFTH",
            "3, false, FIFTH",
            "2, true, MISS",
            "2, false, MISS",
            "1, true, MISS",
            "1, false, MISS",
            "0, true, MISS",
            "0, false, MISS",
    })
    void valueOf(int matchCount, boolean bonusMatch, LottoPrize lottoPrize) {
        // when then
        assertThat(LottoPrize.valueOf(matchCount, bonusMatch)).isEqualTo(lottoPrize);
    }
}