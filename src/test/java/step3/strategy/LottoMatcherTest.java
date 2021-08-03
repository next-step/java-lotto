package step3.strategy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Lotto;
import step3.domain.Winning;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
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

    @DisplayName("로또 번호 맞춰보기")
    @Test
    void matchLottoTest(){
        Lotto myLotto = Lotto.from(Arrays.asList(1,2,3,4,5,6));
        Lotto matchLotto = Lotto.from(Arrays.asList(1,2,3,7,8,9));

        assertThat(matcher.matchLotto(myLotto,matchLotto)).isEqualTo(3);
    }

}