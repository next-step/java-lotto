package me.devyonghee.lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

@DisplayName("로또 번호")
class LottoNumberTest {

    @ParameterizedTest
    @DisplayName("객체화")
    @ValueSource(ints = {1, 45})
    void instance(int number) {
        assertThatNoException().isThrownBy(() -> LottoNumber.from(number));
    }

    @ParameterizedTest(name = "[{index}] {0} 로 로또 번호 생성 불가")
    @DisplayName("로또 번호는 반드시 1에서 45 사이")
    @ValueSource(ints = {0, 46})
    void instance_outOrRange_thrownIllegalArgumentsException(int number) {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.from(number));
    }
}
