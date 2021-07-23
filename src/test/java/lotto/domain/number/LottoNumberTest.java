package lotto.domain.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


@DisplayName("로또 숫자 테스트")
class LottoNumberTest {

    @DisplayName("로또 숫자는 1 ~ 45 숫자로만 초기화 가능하다")
    @ValueSource(ints = {1, 25, 45})
    @ParameterizedTest
    void initLottoNumber(int number) {
        assertThat(LottoNumber.from(number)).isNotNull();
    }

    @DisplayName("1~45 범위의 숫자가 아니면 초기화 시에 예외를 발생시킨다")
    @ValueSource(ints = {-1, 0, 46})
    @ParameterizedTest
    void initExceptionWhenOutOfRange(int number) {
        assertThatThrownBy(() -> LottoNumber.from(number)).isInstanceOf(IllegalArgumentException.class);
    }
}
