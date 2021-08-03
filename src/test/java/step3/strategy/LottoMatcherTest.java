package step3.strategy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Winning;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMatcherTest {

    static LottoMatcher matcher;
    List<Winning> winnings;

    @BeforeAll
    static void makeMatcher() {
        matcher = new LottoMatcher();
    }

    @BeforeEach
    void resetList(){
        winnings = new ArrayList<>();
    }

    @DisplayName("2등 당첨 확인하기")
    @Test
    void matchSecondTest() {
        winnings.add(matcher.getWinning( 5, true));
        assertThat(winnings.get(0)).isEqualTo(Winning.SECOND);
    }

    @DisplayName("3등 당첨 확인하기")
    @Test
    void matchThirdTest() {
        winnings.add(matcher.getWinning( 5, false));
        assertThat(winnings.get(0)).isEqualTo(Winning.THIRD);
    }

}