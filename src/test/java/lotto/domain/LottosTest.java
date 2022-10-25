package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottosTest {

    @DisplayName("1등 로또와 매칭하는 결과를 구한다.")
    @Test
    void winning_lotto() {

        final WinningLotto 우승로또 = WinningLotto.from("1, 2, 3, 4, 5, 6", "45");
        final Lotto 구매로또 = Lotto.from("1, 2, 3, 4, 5, 6");

        assertThat(WinningPrize.of(우승로또, 구매로또)).isEqualTo(WinningPrize.FIRST);
    }

    @DisplayName("로또 번호는 5개만 입력 또는 7개 이상 입력하거나 중복된 숫자를 입력하면 익셉션 처리한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 2, 4, 5, 6", "1, 2, 3, 4, 5", "1, 2, 3, 4, 5, 6, 7"})
    void error_create_lotto2(final String input) {

        assertThatThrownBy(() -> Lotto.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("6개의 숫자를 입력해야 하며 중복 숫자는 입력할 수 없습니다.");
    }
}
