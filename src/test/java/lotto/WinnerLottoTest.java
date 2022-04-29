package lotto;

import lotto.dto.WinnerLotto;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또 당첨번호를 로또로 변환해주는 클래스 테스트")
public class WinnerLottoTest {

    public static final WinnerLotto WINNER_LOTTO = new WinnerLotto("1, 2, 3, 4, 5, 6");

    @Test
    @DisplayName("로또 당첨번호 문자가 null일 경우 NullPointerException이 발생한다.")
    void nullTest() {
        assertThatThrownBy(() -> new WinnerLotto(null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("로또 당첨번호 문자가 빈 값일 경우 예외가 발생한다.")
    void blankTest() {
        assertThatThrownBy(() -> new WinnerLotto(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 당첨번호가 6개로 이루어져있지 않을 경우 예외가 발생한다.")
    void stringSizeFailTest() {
        assertThatThrownBy(() -> new WinnerLotto("1, 2, 3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("6개로 이루어져야 합니다.");
    }

    @Test
    @DisplayName("로또 당첨번호 입력 형식이 올바르지 않은 경우 예외가 발생한다.")
    void stringFormatFailTest() {
        assertThatThrownBy(() -> new WinnerLotto("1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력이 올바르지 않습니다.");
    }

    @Test
    @DisplayName("로또 당첨번호를 입력하면 로또를 반환해준다.")
    void winnerLottoTest() {
        // given
        Lotto winnerLotto = WINNER_LOTTO.getLotto();

        // when
        Lotto matchLotto = LottoTest.TEST_LOTTO;

        // then
        assertThat(matchLotto.getMatchCount(winnerLotto)).isEqualTo(6);
    }
}
