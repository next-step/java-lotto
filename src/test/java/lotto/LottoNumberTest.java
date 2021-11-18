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
    @MethodSource("constructorMethodSource")
    @DisplayName("로또번호는 1이상 45이하의 범위를 갖는다.")
    void constructorMethod(int fail, int success) {
        LottoNumber lottoNumber = new LottoNumber(success);

        assertThat(lottoNumber).isEqualTo(new LottoNumber(success));

        assertThatThrownBy(() -> {
            new LottoNumber(fail);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> constructorMethodSource() {
        return Stream.of(
                Arguments.of(-1, 1),
                Arguments.of(0, 15),
                Arguments.of(46, 45)
        );
    }
}
