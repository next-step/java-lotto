package lottery_bonus;

import lottery_bonus.type.WinningMatch;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningMatchTest {

    @ParameterizedTest
    @CsvSource(value = {"3.0, MATCH_3", "5.5, MATCH_5_BONUS", "0.0, MATCH_NON_VALUE"})
    @DisplayName("일치하는 WinningMatch 찾기 테스트")
    void equal(double score, WinningMatch winningMatch) {
        assertThat(WinningMatch.equal(score)).isEqualTo(winningMatch);
    }

    @Test
    @DisplayName("의미있는 WinningMatch만 리턴 테스트")
    void getWinningMatchesExistsNonMatchValue() {
        List<WinningMatch> winningMatchList = WinningMatch.getWinningMatchesExistsNonMatchValue();
        assertThat(winningMatchList.size()).isEqualTo(5);
    }
}