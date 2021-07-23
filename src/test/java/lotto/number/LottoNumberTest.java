package lotto.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

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

    @DisplayName("1 ~ 45 범위의 숫자가 아니면 초기화 시에 예외를 발생시킨다")
    @ValueSource(ints = {-1, 0, 46})
    @ParameterizedTest
    void initExceptionWhenOutOfRange(int number) {
        assertThatThrownBy(() -> LottoNumber.from(number)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호는 항상 같은 객체를 반환한다")
    @MethodSource
    @ParameterizedTest
    void singletonLottoNumber(int number, LottoNumber expectedLottoNumber) {
        assertThat(LottoNumber.from(number)).isEqualTo(expectedLottoNumber);
    }

    private static Stream<Arguments> singletonLottoNumber() {
        return Stream.of(
                Arguments.of(1, LottoNumber.from(1)),
                Arguments.of(5, LottoNumber.from(5)),
                Arguments.of(10, LottoNumber.from(10))
        );
    }
}
