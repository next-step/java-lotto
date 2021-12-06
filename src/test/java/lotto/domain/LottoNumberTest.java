package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    @ValueSource(ints = {-1, 0, 46, 1000})
    @ParameterizedTest(name = "[{argumentsWithNames}] 로또번호에 1~45 숫자가 아닌경우, RuntimeException 이 발생한다.")
    void createExceptionTest(int input) {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.create(input));
    }

    @Test
    @DisplayName("LottoNumber의 객체는 캐싱이 적용되어, 같은 값의 객체는 1번만 생성된다.")
    void createCacheTest() {
        assertThat(LottoNumber.create(10)).isSameAs(LottoNumber.create(10));
    }

}