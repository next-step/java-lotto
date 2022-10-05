package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoNumberTest {

    @DisplayName("1등 로또 번호가 null 또는 빈 값일 경우 익셉션 처리한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void error_create_winning_lotto(final String winningLotto) {

        assertThatThrownBy(() -> WinningLottoNumber.from(winningLotto, "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력 값이 null 또는 빈 공백 입니다.");
    }

    @DisplayName("보너스 번호가 null 또는 빈 값일 경우 익셉션 처리한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void error_create_bonus_number(final String bonusBall) {

        assertThatThrownBy(() -> WinningLottoNumber.from("1, 2, 3, 4, 5, 6", bonusBall))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력 값이 null 또는 빈 공백 입니다.");
    }

    @DisplayName("입력받은 값으로 1등 로또 번호와 보너스번호를 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void create_winning_lotto(final int number) {

        final WinningLottoNumber winningLottoNumber = WinningLottoNumber.from("1, 2, 3, 4, 5, 6", "1");
        assertThat(winningLottoNumber.getWinnerLottoNumber()).contains(new Number(number));
    }

    @DisplayName("보너스 번호는 숫자만 생성가능하다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "?", "%"})
    void error_bonus_number(final String bonusNumber) {

        assertThatThrownBy(() -> WinningLottoNumber.from("1, 2, 3, 4, 5, 6", bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력해야 합니다.");
    }

    @DisplayName("보너스 번호는 1 ~ 45 번호 사이에서 생성가능하다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "46"})
    void error_bonus_number2(final String number) {

        assertThatThrownBy(() -> WinningLottoNumber.from("1, 2, 3, 4, 5, 6", number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 숫자는 1 ~ 45 사이여야 합니다.");
    }
}
