package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinningPriceTest {



    @Test
    @DisplayName("당첨 등수 테스트")
    void decide_Grade_Test(){
        assertThat(WinningPrice.decideGrade(new MatchingResult(5, true))).isEqualTo(WinningPrice.SECOND);
        assertThat(WinningPrice.decideGrade(new MatchingResult(5, false))).isEqualTo(WinningPrice.THIRD);
        assertThat(WinningPrice.decideGrade(new MatchingResult(6, true))).isEqualTo(WinningPrice.FIRST);
        assertThat(WinningPrice.decideGrade(new MatchingResult(6, false))).isEqualTo(WinningPrice.FIRST);
    }

}