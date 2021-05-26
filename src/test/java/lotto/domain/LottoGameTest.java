package lotto.domain;

import lotto.exception.IllegalLottoNumberCountException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static lotto.domain.LottoGame.createManual;
import static lotto.domain.LottoNumber.valueOf;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LottoGame 테스트")
class LottoGameTest {
    @ParameterizedTest
    @MethodSource("provideSource_new_정상")
    @DisplayName("new_정상")
    void new_정상(Set<LottoNumber> values) {

        // When, Then
        assertDoesNotThrow(() -> createManual(values));
    }

    static Stream<Arguments> provideSource_new_정상() {
        return Stream.of(
                Arguments.of(new HashSet(Arrays.asList(valueOf(1), valueOf(2), valueOf(3), valueOf(4), valueOf(5), valueOf(6)))),
                Arguments.of(new HashSet(Arrays.asList(valueOf(11), valueOf(12), valueOf(13), valueOf(14), valueOf(15), valueOf(16)))),
                Arguments.of(new HashSet(Arrays.asList(valueOf(21), valueOf(22), valueOf(23), valueOf(24), valueOf(25), valueOf(26))))
        );
    }

    @ParameterizedTest
    @MethodSource("provideSource_new_예외")
    @DisplayName("new_예외")
    void new_예외(Set<LottoNumber> values) {
        // When, Then
        assertThatExceptionOfType(IllegalLottoNumberCountException.class)
                .isThrownBy(() -> createManual(values));
    }

    static Stream<Arguments> provideSource_new_예외() {
        return Stream.of(
                Arguments.of(new HashSet(Arrays.asList(valueOf(1)))),
                Arguments.of(new HashSet(Arrays.asList(valueOf(1), valueOf(2)))),
                Arguments.of(new HashSet(Arrays.asList(valueOf(1), valueOf(2), valueOf(3)))),
                Arguments.of(new HashSet(Arrays.asList(valueOf(1), valueOf(2), valueOf(3), valueOf(4)))),
                Arguments.of(new HashSet(Arrays.asList(valueOf(1), valueOf(2), valueOf(3), valueOf(4), valueOf(5)))),
                Arguments.of(new HashSet(Arrays.asList(valueOf(1), valueOf(2), valueOf(3), valueOf(4), valueOf(5), valueOf(6), valueOf(7))))
        );
    }

    @RepeatedTest(100)
    @DisplayName("createAuto_정상")
    void createAuto_정상() {
        // When
        LottoGame lottoGame = LottoGame.createAuto();

        // Then
        assertEquals(LottoGame.LOTTO_NUMBER_COUNT, lottoGame.size());
    }

    @Test
    void test() {
        List<LottoNumber> lottoNumbers = LottoGame.RANDOM_LOTTO_NUMBERS;
        lottoNumbers = LottoGame.RANDOM_LOTTO_NUMBERS;
        lottoNumbers = LottoGame.RANDOM_LOTTO_NUMBERS;
        lottoNumbers = LottoGame.RANDOM_LOTTO_NUMBERS;
    }
}