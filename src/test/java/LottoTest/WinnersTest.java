package LottoTest;

import lotto.domain.Rank;
import lotto.domain.Winners;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinnersTest {
    private Winners winners;

    @BeforeEach
    void setUp() {
        winners = new Winners();
    }

    @Test
    @DisplayName("wins 초기값 테스트")
    void When_Wins_Then_Zero() {
        assertThat(winners.wins(Rank.FIRST)).isEqualTo(0);
    }

    @Test
    @DisplayName("increase 테스트")
    void When_Increase_Then_One() {
        //when
        winners.increase(Rank.FIFTH);

        //then
        assertThat(winners.wins(Rank.FIFTH)).isEqualTo(1);
    }

    @Test
    @DisplayName("수익율 계산")
    void When_Yield() {
        winners.increase(Rank.FIFTH);

        assertThat(winners.yield(10000)).isEqualTo(Rank.FIFTH.prize() / 10000d);
    }
}
