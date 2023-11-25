package lotto;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {
    @DisplayName("정상적이지 않은 입력에 대해서 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0,46,47})
    void validateBonusBall(int input) {
        assertThatIllegalArgumentException().isThrownBy(() ->LottoNumber.from(input));
        assertThatCode(() -> LottoNumber.from(1))
                .doesNotThrowAnyException();
    }
}
