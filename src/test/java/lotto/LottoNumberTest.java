package lotto;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    @DisplayName("로또번호는 1~45의 숫자가 아니면 IllegalArgumentException이 발생한다")
    public void 로또번호는_1_45의_숫자가_아니면_IllegalArgumentException이_발생한다(int number) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumber(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,43,44,45})
    @DisplayName("로또번호는 1~45의 숫자를 갖는다.")
    public void 로또번호는_1_45의_숫자를_갖는다(int number) {
        assertDoesNotThrow(() -> new LottoNumber(number));
    }
}
