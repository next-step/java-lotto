package com.nextstep.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {
    @DisplayName("로또 숫자가 6개가 아닐 경우 예외처리")
    @Test
    void lotto() {
        assertThatIllegalArgumentException().isThrownBy(() -> toLotto(1,2,3,4,5));
    }

    @DisplayName("숫자 포함 여부")
    @ParameterizedTest
    @CsvSource({"1,true", "7,false"})
    void contains(int number, boolean expected) {
        Lotto lotto = toLotto(1,2,3,4,5,6);
        LottoNumber lottoNumber = LottoNumber.of(number);
        assertThat(lotto.contains(lottoNumber)).isEqualTo(expected);
    }

    private static Lotto toLotto(int ... numbers) {
        return IntStream.of(numbers)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Lotto::new));
    }
}