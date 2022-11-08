package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    private static final String EXCEPTION_MESSAGE_PREFIX = "[ERROR]";
    private static final int MIN = 1;
    private static final int MAX = 45;

    @ParameterizedTest
    @ValueSource(ints = {-10, -5, -1, 0, 46, 47, 50, 100})
    void invalidValue(final int value) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> LottoNumber.valueOf(value))
            .withMessageContaining(EXCEPTION_MESSAGE_PREFIX);
    }

    @Test
    void validValue() {
        IntStream.rangeClosed(MIN, MAX)
            .forEach((value) ->
                assertThatCode(() -> LottoNumber.valueOf(value)).doesNotThrowAnyException());
    }

    @Test
    void equals() {
        IntStream.rangeClosed(MIN, MAX)
            .forEach((value) ->
                assertThat(LottoNumber.valueOf(value)).isEqualTo(LottoNumber.valueOf(value)));

    }

    @Test
    void cached() {
        IntStream.rangeClosed(MIN, MAX)
            .forEach((value) ->
                assertThat(LottoNumber.valueOf(value)).isSameAs(LottoNumber.valueOf(value)));
    }

}
