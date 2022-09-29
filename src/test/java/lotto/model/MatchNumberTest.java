package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.model.MatchNumber.*;
import static org.assertj.core.api.Assertions.assertThat;

class MatchNumberTest {

    @Test
    void shouldCompare() {
        assertThat(SIX.compareTo(SIX_WITH_BONUS_BALL)).isPositive();
        assertThat(SIX_WITH_BONUS_BALL.compareTo(FIVE)).isPositive();
        assertThat(ONE.compareTo(SIX)).isNegative();
        assertThat(SIX.compareTo(SIX)).isZero();
    }

    @Test
    void shouldGetMatchNumber() {
        MatchNumber matchNumberA = getMatchNumber(List.of(LottoBall.bonusBall(1)));
        MatchNumber matchNumberB = getMatchNumber(getLottoBallWithBonus());
        MatchNumber matchNumberC = getMatchNumber(getLottoBallWithOutBonus());

        assertThat(matchNumberA).isEqualTo(ONE);
        assertThat(matchNumberB).isEqualTo(SIX_WITH_BONUS_BALL);
        assertThat(matchNumberC).isEqualTo(SIX);
    }

    private List<LottoBall> getLottoBallWithOutBonus() {
        LottoBall ball = LottoBall.noBonusBall(1);
        return List.of(ball, ball, ball, ball, ball, ball);
    }

    private List<LottoBall> getLottoBallWithBonus() {
        LottoBall ball = LottoBall.noBonusBall(1);
        return List.of(ball, ball, ball, ball, ball, LottoBall.bonusBall(99));
    }

}
