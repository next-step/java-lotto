package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {

    @Test
    @DisplayName("로또 정상 생성 테스트")
    void lotto_create() {
        /* given & when & then */
        assertDoesNotThrow(() -> new Lotto(getBalls("1", "2", "3", "4", "5", "6")));
    }

    @Test
    @DisplayName("로또 개수 검증 테스트")
    void lotto_invalidBallsSize() {
        /* given & when & then */
        assertThatThrownBy(() -> new Lotto(getBalls("1", "2", "3", "4", "5"))).isExactlyInstanceOf(
                IllegalArgumentException.class);

        assertThatThrownBy(() -> new Lotto(getBalls("1", "2", "3", "4", "5", "6", "7"))).isExactlyInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호 중복 테스트")
    void lotto_duplicateBalls() {
        /* given & when & then */
        assertThatThrownBy(() -> new Lotto(getBalls("1", "2", "3", "4", "4", "6")))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호가 지난 주 당첨 번호에 포함될 경우 예외처리 테스트")
    void lotto_duplicateBonus() {
        /* given */
        final Lotto winningBalls = new Lotto(getBalls("1", "2", "3", "4", "5", "6"));
        final Ball bonusBall = new Ball("6");

        /* when & then */
        assertThatThrownBy(() -> new WinningLotto(winningBalls, bonusBall))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호 오름차순 정렬 테스트")
    void lotto_sortBallsByAscending() {
        /* given */
        final Lotto lotto = new Lotto(getBalls("6", "5", "4", "3", "2", "1"));

        /* when & then */
        assertThat(lotto).isEqualTo(new Lotto(getBalls("1", "2", "3", "4", "5", "6")));
    }

    static List<Ball> getBalls(final String... args) {
        final List<Ball> balls = new ArrayList<>();

        for (String arg : args) {
            balls.add(new Ball(arg));
        }

        return balls;
    }
}
