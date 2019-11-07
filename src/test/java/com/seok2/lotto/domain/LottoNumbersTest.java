package com.seok2.lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Java6Assertions.assertThat;

import com.seok2.lotto.exception.LottoDuplicateNumberException;
import com.seok2.lotto.exception.LottoLengthException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoNumbersTest {


    private final LottoNumbers lottoNumbers= LottoNumbers.of(4, 7, 2, 1, 5, 10);

    static Stream<Arguments> throwLottoLengthException() {
        return Stream.of(
            Arguments.of(new int[]{1, 2, 3, 4, 5}),
            Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7})
        );
    }

    @Test
    void sort() {
        assertThat(lottoNumbers.toString()).isEqualTo("[1, 2, 4, 5, 7, 10]");
    }

    @Test
    void throwLottoDuplicateNumberException() {
        assertThatThrownBy(() -> LottoNumbers.of(4, 7, 1, 1, 5, 10))
            .isInstanceOf(LottoDuplicateNumberException.class);
    }

    @ParameterizedTest
    @MethodSource("throwLottoLengthException")
    void throwLottoLengthException(int... values) {
        assertThatThrownBy(() -> LottoNumbers.of(values))
            .isInstanceOf(LottoLengthException.class);
    }

    @Test
    void match() {
        assertThat(lottoNumbers.match(LottoNumbers.of(4, 7, 2, 40, 41, 42))).isEqualTo(3);
    }

    @Test
    void contains() {
        assertThat(lottoNumbers.contains(LottoNumber.of(4))).isTrue();
        assertThat(lottoNumbers.contains(LottoNumber.of(30))).isFalse();
    }
}
