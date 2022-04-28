package lotto;

import lotto.dto.WinnerLottos;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또 당첨번호를 로또로 변환해주는 클래스 테스트")
public class WinnerLottosTest {

    @Test
    @DisplayName("로또 당첨번호 문자가 null일 경우 NullPointerException이 발생한다.")
    void nullTest() {
        assertThatThrownBy(() -> new WinnerLottos(null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("로또 당첨번호 문자가 빈 값일 경우 예외가 발생한다.")
    void blankTest() {
        assertThatThrownBy(() -> new WinnerLottos(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 당첨번호가 6개로 이루어져있지 않을 경우 예외가 발생한다.")
    void stringSizeFailTest() {
        assertThatThrownBy(() -> new WinnerLottos("1, 2, 3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("6개로 이루어져야 합니다.");
    }

    @Test
    @DisplayName("로또 당첨번호 입력 형식이 올바르지 않은 경우 예외가 발생한다.")
    void stringFormatFailTest() {
        assertThatThrownBy(() -> new WinnerLottos("1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력이 올바르지 않습니다.");
    }

    @Test
    @DisplayName("로또 당첨번호를 입력하면 로또를 반환해준다.")
    void winnerLottosTest() {
        // given
        Lottos winnerLottos = new WinnerLottos("1, 2, 3, 4, 5, 6").getLottos();

        // when
        Lottos matchLottos = new Lottos(Lists.newArrayList(1, 2, 3, 4, 5, 6));

        // then
        assertThat(matchLottos.getMatchCount(winnerLottos)).isEqualTo(6);
    }
}
