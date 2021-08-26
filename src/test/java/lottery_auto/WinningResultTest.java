package lottery_auto;

import static org.assertj.core.api.Assertions.assertThat;

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
        winningResult = new WinningResult(Arrays.asList(3,4,5,6));
    }

    @Test
    @DisplayName("WinningResult 생성자 테스트")
    void match() {
        assertThat(winningResult).isNotNull();
    }

    @ParameterizedTest
    @CsvSource(value = {"MATCH_3,1", "MATCH_4,1", "MATCH_5,1", "MATCH_6,1", "MATCH_NON_VALUE,0"})
    @DisplayName("3-6개 사이로 일치하는 로또 숫자를 카운트 테스트")
    void compareCnt(WinningMatch winningMatch, int count) {
        assertThat(winningResult.compareCnt(winningMatch)).isEqualTo(count);
    }

    @Test
    @DisplayName("당첨금계산 테스트")
    void sum() {
        assertThat(winningResult.sum()).isEqualTo(2_001_555_000);
    }
}
