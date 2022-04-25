package me.devyonghee.lotto.model;

import me.devyonghee.common.StringsProvider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

@DisplayName("우승 로또 생성기")
class WinnerLottoGeneratorTest {

    @Test
    @DisplayName("문자 제공자로 우승 로또 생성기 정상 생성")
    void instance() {
        assertThatNoException().isThrownBy(() -> WinnerLottoGenerator.of(() -> Collections.singletonList("1"), LottoNumber.from(1)));
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("문자 제공자와 보너스 번호는 필수")
    void instance_nullArguments_thrownNullPointerException(StringsProvider provider, LottoNumber lottoNumber) {
        assertThatNullPointerException().isThrownBy(() -> WinnerLottoGenerator.of(provider, lottoNumber));
    }

    @Test
    @DisplayName("우승 로또 생성")
    void lotto() {
        //given
        LottoNumber bonusNumber = LottoNumber.from(7);
        //when, then
        assertThat(WinnerLottoGenerator.of(() -> Arrays.asList("1", "2", "3", "4", "5", "6"), bonusNumber).lotto())
                .isEqualTo(WinnerLotto.of(Lotto.from(LottoNumbersTest.ONE_TO_SIX_NUMBERS), bonusNumber));
    }

    private static Stream<Arguments> instance_nullArguments_thrownNullPointerException() {
        return Stream.of(
                Arguments.of(null, LottoNumber.from(1)),
                Arguments.of((StringsProvider) () -> Collections.singletonList("1"), null)
        );
    }
}
