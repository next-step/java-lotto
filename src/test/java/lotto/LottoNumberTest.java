package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {
    @ParameterizedTest
    @MethodSource("constructorMethodSuccessSource")
    @DisplayName("LottoNumber 는 유효한 번호를 인자로 전달받아 생성할 수 있다.")
    void constructorMethodSuccess(int number) {
        // given
        LottoNumber me = new LottoNumber(number);

        // when
        LottoNumber other = new LottoNumber(number);

        // then
        assertThat(me).isEqualTo(other);
    }

    static Stream<Arguments> constructorMethodSuccessSource() {
        return Stream.of(
                Arguments.of(1),
                Arguments.of(20),
                Arguments.of(45)
        );
    }

    @ParameterizedTest
    @MethodSource("constructorMethodFailSource")
    @DisplayName("LottoNumber 는 유효한 번호를 전달 받지 못한 경우 생성할 수 없다.")
    void constructorMethodFail(int number) {
        // given
        assertThatThrownBy(() -> {
            new LottoNumber(number);
        }).isInstanceOf(IllegalArgumentException.class);

        // when

        // then
    }

    static Stream<Arguments> constructorMethodFailSource() {
        return Stream.of(
                Arguments.of(-1),
                Arguments.of(0),
                Arguments.of(46)
        );
    }
}
