package lotto.domain.winning;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningBallTest {

    @Test
    @DisplayName("객체 생성 테스트")
    void create() {
        assertThat(new WinningBall(Lotto.winningLotto("1,2,3,4,5,6"), new LottoNumber(7)))
                .isInstanceOf(WinningBall.class);
    }

    @Test
    @DisplayName("당첨번호와 보너스 번호중 겹치는 번호가 있을경우 예외 리턴")
    void createWithSameNumber() {
        assertThatThrownBy(() -> new WinningBall(Lotto.winningLotto("1,2,3,4,5,6"), new LottoNumber(6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호 갯수 확인 및 보너스번호 확인 테스트")
    void statCount() {
        final WinningBall winningBall = new WinningBall(Lotto.winningLotto("1,2,3,4,5,6"), new LottoNumber(7));
        final Lotto second = new Lotto(new LottoNumbers("1,2,3,4,5,7"));

        assertThat(winningBall.statCount(second))
                .isEqualTo(5);
        assertThat(winningBall.isBonusBall(second))
                .isTrue();
    }
}
