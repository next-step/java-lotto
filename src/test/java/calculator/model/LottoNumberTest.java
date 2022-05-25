package calculator.model;

import lotto.domain.IntNumber;
import lotto.domain.LottoNumber;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void 로또_번호가_정상범위를_벗어날_때(int number) {
        final String INVALID_NUMBER = "숫자는 1 ~ 45 까지의 숫자만 가능합니다.";

        assertThatThrownBy(() -> new LottoNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_NUMBER);
    }

    @ParameterizedTest
    @MethodSource("정상적인_숫자의_문자_매개변수")
    void 정상적인_숫자의_문자일때(String numberText, int resultNumber) {
        assertThat(new LottoNumber(new IntNumber(numberText)).getNumber().getNumber()).isEqualTo(resultNumber);
    }

    static Stream<Arguments> 정상적인_숫자의_문자_매개변수() {
        return Stream.of(
                arguments("45", 45),
                arguments("1", 1),
                arguments("28", 28)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "46"})
    void 비정상적인_숫자의_문자일때(String numberText) {
        assertThatThrownBy(() -> new LottoNumber(new IntNumber(numberText)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
