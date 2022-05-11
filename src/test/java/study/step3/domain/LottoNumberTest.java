package study.step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("번호")
class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1,45})
    @DisplayName("번호 범위 1~45 테스트")
    void 번호범위_1_45_테스트(int inputNumber) {
        // given
        LottoNumber number = new LottoNumber(inputNumber);
        // when
        // then
        assertThat(number).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(ints = {0,46})
    @DisplayName("잘못된 번호 예외 테스트")
    void 잘못된_번호_예외_테스트(int inputNumber) {
        // given
        // when, then
        assertThatIllegalArgumentException().isThrownBy(() -> {
           new LottoNumbers(inputNumber);
        });
    }
}