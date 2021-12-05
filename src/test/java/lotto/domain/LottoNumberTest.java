package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    @ValueSource(ints = {-1, 0, 46, 1000})
    @ParameterizedTest(name = "[{argumentsWithNames}] 로또번호에 1~45 숫자가 아닌경우, RuntimeException 이 발생한다.")
    void createExceptionTest(int input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(input));
    }

}