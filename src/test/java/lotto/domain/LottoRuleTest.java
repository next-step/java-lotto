package lotto.domain;

import lotto.domain.LottoRule;
import lotto.domain.LottoRule.WINNING_VALUE;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoRuleTest {
    @ParameterizedTest
    @DisplayName("당첨 시 금액 확인")
    @CsvSource(value = {"3:5000", "4:50000", "6:2000000000"}, delimiter = ':')
    void amountCheckByWinning(int matchCount, int expectedAmount) {
        WINNING_VALUE result = WINNING_VALUE.findByMatchCount(matchCount);
        assertThat(result.getAmount()).isEqualTo(expectedAmount);
    }

    @Test
    @DisplayName("최소 당첨 개수보다 작을때 throw IllegalArgumentException")
    void exceptByLessWinningMinCount() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            WINNING_VALUE.findByMatchCount(2);
        }).withMessage("당첨 되지 않았습니다.");

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            WINNING_VALUE.findByMatchCount(0);
        }).withMessage("당첨 되지 않았습니다.");
    }

    @ParameterizedTest
    @DisplayName("통합 테스트")
    @CsvSource(value = {"0:0", "1:0", "2:0", "3:5000", "4:50000", "6:2000000000"}, delimiter = ':')
    void totalTest(int matchCount, int expectedAmount) {
        if (matchCount >= LottoRule.getWinningMinCount()) {
            WINNING_VALUE result = WINNING_VALUE.findByMatchCount(matchCount);
            assertThat(result.getAmount()).isEqualTo(expectedAmount);
        }
    }
}