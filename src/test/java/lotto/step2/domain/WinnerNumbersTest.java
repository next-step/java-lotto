package lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinnerNumbersTest {
    @ParameterizedTest
    @ValueSource(ints = {10, 12, 30, 34, 40, 45})
    @DisplayName("보너스 번호로 당첨 번호랑 중복되게 입력하면, IllegalArgumentException 예외가 발생한다.")
    void throwIllegalArgumentExceptionForDuplicateBonusNumber(final int bonusNumber) {
        // given
        final LottoNumber bonusLottoNumber = new LottoNumber(bonusNumber);
        final Lotto winnerLotto = new Lotto(Set.of(10, 12, 30, 34, 40, 45));

        // when, then
        assertThatThrownBy(() -> new WinnerNumbers(winnerLotto, bonusLottoNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("bonus winner number must not be in winner nums");
    }
}
