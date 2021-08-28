package lottery_auto;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Arrays;
import lottery_auto.domain.WinningResult;
import lottery_auto.type.WinningMatch;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WinningResultTest {
    private WinningResult winningResult;

    @BeforeEach
    void setUp() {
        winningResult = new WinningResult(Arrays.asList(3,0,0,0));
    }

    @Test
    @DisplayName("WinningResult 생성자 테스트")
    void match() {
        assertThat(winningResult).isNotNull();
    }

    @ParameterizedTest
    @CsvSource(value = {"MATCH_3,1", "MATCH_4,0", "MATCH_5,0", "MATCH_6,0", "MATCH_NON_VALUE,3"})
    @DisplayName("3-6개 사이로 일치하는 로또 숫자를 카운트 테스트")
    void compareMatch(WinningMatch winningMatch, int count) {
        assertThat(winningResult.compareMatch(winningMatch)).isEqualTo(count);
    }

    @ParameterizedTest
    @CsvSource(value = {"6000,0.83","5000,1.00", "4000,1.25"})
    @DisplayName("수익률 계산 테스트")
    void sum(BigDecimal amount, Double profit) {
        assertThat(winningResult.calculateProfit(amount)).isEqualTo(profit);
    }
}
