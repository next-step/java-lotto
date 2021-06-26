package lotto.core.round;

import lotto.core.SixBall;
import lotto.core.exception.LottoRuleException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또 특정회차 테스트")
class RoundTest {

    @Test
    @DisplayName("로또 당첨번호 직접입력")
    public void fixedBallsTest() {
        Round round = new Round(1, WinSixBall.valueOf(1, 2, 3, 4, 5, 6), 7);

        System.out.println(round);
        assertThat(round).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, -1, 0, 46})
    @DisplayName("잘못된 보너스볼")
    public void wrongBonusBallTest(int bonus) {
        assertThatThrownBy(() -> new Round(1, WinSixBall.valueOf(1, 2, 3, 4, 5, 6), bonus))
                .isInstanceOf(LottoRuleException.class);
    }
}