package lottery_bonus;

import lottery_bonus.domain.WinningResult;
import lottery_bonus.type.WinningMatch;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class WinningResultTest {
    private WinningResult winningResult;

    @BeforeEach
    void setUp() {
        winningResult = new WinningResult(Arrays.asList(new Double(5.5), new Double(0)));
    }

    @Test
    @DisplayName("WinningResult 생성자 테스트")
    void match() {
        assertThat(winningResult).isNotNull();
    }

    @ParameterizedTest
    @CsvSource(value = {"MATCH_3,0", "MATCH_5_BONUS,1", "MATCH_NON_VALUE,1"})
    @DisplayName("3-6개 사이로 일치하는 로또 숫자를 카운트 테스트")
    void compareMatch(WinningMatch winningMatch, int count) {
        assertThat(winningResult.getMatchCount(winningMatch)).isEqualTo(count);
    }

    @ParameterizedTest
    @CsvSource(value = {"120000, 250.0","200000, 150.00"})
    @DisplayName("수익률 계산 테스트")
    void sum(BigDecimal amount, Double profit) {
        assertThat(winningResult.calculateProfit(amount)).isEqualTo(profit);
    }
}
