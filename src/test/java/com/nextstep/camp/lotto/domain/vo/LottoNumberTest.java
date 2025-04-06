package com.nextstep.camp.lotto.domain.vo;

import java.util.stream.Stream;

import com.nextstep.camp.lotto.domain.exception.LottoNumberOutOfRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoNumberTest {

    static Stream<Integer> validNumbers() {
        return Stream.of(1, 5, 23, 44, 45);
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("validNumbers")
    void valid_lotto_number_should_be_created(int input) {
        LottoNumber number = LottoNumber.of(input);
        assertEquals(input, number.getValue());
    }

    static Stream<Integer> invalidNumbers() {
        return Stream.of(0, -1, 46, 100);
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("invalidNumbers")
    @DisplayName("범위를 벗어난 숫자는 예외 발생")
    void invalid_lotto_number_should_throw(int input) {
        assertThrows(LottoNumberOutOfRangeException.class, () -> LottoNumber.of(input));
    }
}
