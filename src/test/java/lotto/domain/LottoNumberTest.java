package lotto.domain;

import static lotto.domain.LottoNumber.LOTTO_NUMBER_OUT_OF_RANGE_EXCEPTION;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {
    @ParameterizedTest
    @DisplayName("로또 숫자가 1에서 45 사이인지 검증한다.")
    @ValueSource(ints = {0, 46})
    void validate_lotto_number(int given) {
        // when // then
        assertThatThrownBy(() -> new LottoNumber(given))
                .isExactlyInstanceOf(IllegalStateException.class)
                .hasMessage(LOTTO_NUMBER_OUT_OF_RANGE_EXCEPTION);
    }

    @ParameterizedTest
    @DisplayName("lottoNumberPool에서 lottoNumber를 가져온다.")
    @MethodSource("parametersProvider")
    void find_lotto_number_in_pool(int given, LottoNumber expected) {
        // when
        LottoNumber result = LottoNumber.randomLottoNumber(given);

        // then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> parametersProvider() {
        return Stream.of(
                arguments("1", new LottoNumber(1)),
                arguments("45", new LottoNumber(45))
        );
    }
}
