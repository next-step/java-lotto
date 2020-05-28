package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @DisplayName("1 ~ 45 사이의 수로 LottoNumber 생성하는데 성공")
    @ParameterizedTest
    @MethodSource("source_generateByManual_validParameters_shouldSucceed")
    public void generateByManual_validParameters_shouldSucceed(int param, LottoNumber expected) {
        LottoNumber result = LottoNumber.generateByManual(param);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> source_generateByManual_validParameters_shouldSucceed() {
        return Stream.of(
                Arguments.of(1, LottoNumber.generateByManual(1)),
                Arguments.of(16, LottoNumber.generateByManual(16)),
                Arguments.of(45, LottoNumber.generateByManual(45)));
    }

    @DisplayName("1 ~ 45 바깥의 수로 LottoNumber 생성시에 throw IllegalArgumentException")
    @ParameterizedTest
    @MethodSource("source_generateByManual_invalidParameters_shouldFail")
    public void generateByManual_invalidParameters_shouldFail(int param) {
        assertThatThrownBy(() -> {
            LottoNumber.generateByManual(param);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> source_generateByManual_invalidParameters_shouldFail() {
        return Stream.of(
                Arguments.of(-1),
                Arguments.of(0),
                Arguments.of(46));
    }
}
