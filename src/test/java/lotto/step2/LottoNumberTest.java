package lotto.step2;

import lotto.step2.domain.LottoNumber;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @ParameterizedTest(name = "숫자_범위_Test")
    @ValueSource(strings = {"0", "46"})
    public void 숫자_범위_Test(String input) {
        assertThatThrownBy(() -> new LottoNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효범위를 벗어난 숫자입니다.");
    }

    @ParameterizedTest(name = "숫자_타입_Test")
    @ValueSource(strings = {"1a", "가"})
    public void 숫자_타입_Test(String input) {
        assertThatThrownBy(() -> new LottoNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또번호는 정수여야 합니다.");
    }


    @ParameterizedTest(name = "creationTest")
    @MethodSource("arrayProvider")
    public void creationTest(String input, LottoNumber lottoNumber) {
        assertThat(new LottoNumber(input)).isEqualTo(lottoNumber);
    }

    static Stream<Arguments> arrayProvider() {
        return Stream.of(
                Arguments.of("1", new LottoNumber(1)),
                Arguments.of("45", new LottoNumber(45)),
                Arguments.of("23", new LottoNumber(23))
        );
    }
}
