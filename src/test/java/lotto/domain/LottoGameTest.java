package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static lotto.domain.LottoNumber.from;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("LottoGame 테스트")
class LottoGameTest {
    @ParameterizedTest
    @MethodSource("provideSource_new_정상")
    @DisplayName("new_정상")
    void new_정상(Set<LottoNumber> values) {

        // When, Then
        assertDoesNotThrow(() -> new LottoGame(values));
    }

    static Stream<Arguments> provideSource_new_정상() {
        return Stream.of(
                Arguments.of(new HashSet(Arrays.asList(from(1), from(2), from(3), from(4), from(5), from(6)))),
                Arguments.of(new HashSet(Arrays.asList(from(11), from(12), from(13), from(14), from(15), from(16)))),
                Arguments.of(new HashSet(Arrays.asList(from(21), from(22), from(23), from(24), from(25), from(26))))
        );
    }

    @ParameterizedTest
    @MethodSource("provideSource_new_예외")
    @DisplayName("new_예외")
    void new_예외(Set<LottoNumber> values) {
        // When, Then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoGame(values));
    }

    static Stream<Arguments> provideSource_new_예외() {
        return Stream.of(
                Arguments.of(new HashSet(Arrays.asList(from(1)))),
                Arguments.of(new HashSet(Arrays.asList(from(1), from(2)))),
                Arguments.of(new HashSet(Arrays.asList(from(1), from(2), from(3)))),
                Arguments.of(new HashSet(Arrays.asList(from(1), from(2), from(3), from(4)))),
                Arguments.of(new HashSet(Arrays.asList(from(1), from(2), from(3), from(4), from(5)))),
                Arguments.of(new HashSet(Arrays.asList(from(1), from(2), from(3), from(4), from(5), from(6), from(7))))
        );
    }

}