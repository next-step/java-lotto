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
                Arguments.of(1, new LottoNumber(1)),
                Arguments.of(30, new LottoNumber(30))
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void create(int input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(input));
    }

    @ParameterizedTest
    @MethodSource("valid")
    void create(int input, LottoNumber expected) {
        assertThat(new LottoNumber(input)).isEqualTo(expected);
    }

}