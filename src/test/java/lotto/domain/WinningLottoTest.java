package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {

    @DisplayName("입력받은 값으로 1등 로또 번호와 보너스번호를 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void create_winning_lotto(final int number) {

        final WinningLotto winningLotto = WinningLotto.from("1, 2, 3, 4, 5, 6", "1");
        assertThat(winningLotto.getWinnerLotto()).contains(new Number(number));
    }

    @DisplayName("보너스 번호는 숫자만 생성가능하다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "?", "%"})
    void error_bonus_number(final String bonusNumber) {

        assertThatThrownBy(() -> WinningLotto.from("1, 2, 3, 4, 5, 6", bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력해야 합니다.");
    }

    @DisplayName("보너스 번호는 1 ~ 45 번호 사이에서 생성가능하다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "46"})
    void error_bonus_number2(final String number) {

        assertThatThrownBy(() -> WinningLotto.from("1, 2, 3, 4, 5, 6", number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 숫자는 1 ~ 45 사이여야 합니다.");
    }

    @DisplayName("보너스 번호가 일치한다.")
    @Test
    void match_bonus_number() {

        final WinningLotto winningLotto = WinningLotto.from("1, 2, 3, 4, 5, 6", "7");
        final Lotto lotto = Lotto.from("1, 2, 3, 4, 5, 7");

        assertThat(winningLotto.matchBonus(lotto)).isTrue();
    }
}
