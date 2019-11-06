package com.seok2.lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


class LottoNumberTest {

    static Stream<Arguments> valid() {
        return Stream.of(
                Arguments.of(1, LottoNumber.of(1)),
                Arguments.of(30, LottoNumber.of(30))
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void create(int input) {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.of(input));
    }

    @ParameterizedTest
    @MethodSource("valid")
    void create(int input, LottoNumber expected) {
        assertThat(LottoNumber.of(input).hashCode()).isEqualTo(expected.hashCode());
        assertThat(LottoNumber.of(input)).isEqualTo(expected);
    }

}