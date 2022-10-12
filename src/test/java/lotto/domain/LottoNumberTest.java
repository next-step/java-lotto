package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoNumberTest {
    @DisplayName("일치하는 번호 갯수를 리턴한다.")
    @ParameterizedTest
    @MethodSource("matchCountSet")
    void matchCount(LottoNumber lottoNumber, LottoNumber other, int expected) {
        assertThat(lottoNumber.matchCount(other)).isEqualTo(expected);
    }

    @DisplayName("번호 갯수를 리턴한다.")
    @ParameterizedTest
    @MethodSource("countSet")
    void count(List<Integer> numbers, int expectedCount) {
        assertThat(new LottoNumber(numbers).count()).isEqualTo(expectedCount);
    }

    @DisplayName("번호들을 리턴한다.")
    @ParameterizedTest
    @MethodSource("numbersSet")
    void numbers(List<Integer> numbers) {
        assertThat(new LottoNumber(numbers).numbers()).hasSameElementsAs(numbers);
    }

    private static Stream<Arguments> numbersSet() {
        return Stream.of(
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 6)),
                Arguments.arguments(List.of(1, 2, 3, 5, 6))
        );
    }
    
    private static Stream<Arguments> countSet() {
        return Stream.of(
            Arguments.arguments(List.of(1, 2, 3, 4, 5, 6), 6),
            Arguments.arguments(List.of(1, 2, 3, 4, 5), 5),
            Arguments.arguments(Collections.emptyList(), 0),
            Arguments.arguments(null, 0)
        );
    }
    
    private static Stream<Arguments> matchCountSet() {
        return Stream.of(
            Arguments.arguments(new LottoNumber(List.of(1, 2, 3, 4, 5, 6)), new LottoNumber(List.of(1, 2, 3, 4, 5, 6)), 6),
            Arguments.arguments(new LottoNumber(List.of(1, 2, 3, 4, 5, 6)), new LottoNumber(List.of(7, 8, 9, 10, 11, 12)), 0),
            Arguments.arguments(new LottoNumber(List.of(1, 2, 3, 4, 5, 6)), new LottoNumber(Collections.emptyList()), 0),
            Arguments.arguments(new LottoNumber(List.of(1, 2, 3, 4, 5, 6)), new LottoNumber(List.of(1, 2, 6, 7, 8, 9)), 3)
        );
    }
}
