package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoNumberTest {
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

    @DisplayName("일치하는 갯수를 리턴한다.")
    @ParameterizedTest
    @MethodSource("matchingCountSet")
    void matchingCount(LottoNumber number, LottoNumber other, BonusNumber bonusNumber, MatchingCount expected) {
        assertThat(number.matchCount(other, bonusNumber)).isEqualTo(expected);
    }

    private static Stream<Arguments> matchingCountSet() {
        return Stream.of(
                Arguments.arguments(
                        lottoNumber(1, 2, 3, 4, 5, 6),
                        lottoNumber(7, 8, 9, 10, 11, 12),
                        bonusNumber(13),
                        matchingCount(0, false)
                ),
                Arguments.arguments(
                        lottoNumber(1, 2, 3, 4, 5, 6),
                        lottoNumber(6, 8, 9, 10, 11, 12),
                        bonusNumber(5),
                        matchingCount(1, true)
                ),
                Arguments.arguments(
                        lottoNumber(1, 2, 3, 4, 5, 6),
                        lottoNumber(2, 3, 4, 5, 6, 7),
                        bonusNumber(1),
                        matchingCount(5, true)
                )
        );
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
            Arguments.arguments(lottoNumber(1, 2, 3, 4, 5, 6), lottoNumber(1, 2, 3, 4, 5, 6), 6),
            Arguments.arguments(lottoNumber(1, 2, 3, 4, 5, 6), lottoNumber(7, 8, 9, 10, 11, 12), 0),
            Arguments.arguments(lottoNumber(1, 2, 3, 4, 5, 6), lottoNumber(), 0),
            Arguments.arguments(lottoNumber(1, 2, 3, 4, 5, 6), lottoNumber(1, 2, 6, 7, 8, 9), 3)
        );
    }
    
    private static LottoNumber lottoNumber(int... numbers) {
        return new LottoNumber(Arrays.stream(numbers).boxed().collect(Collectors.toList()));
    }
    
    private static BonusNumber bonusNumber(int number) {
        return new BonusNumber(number);
    }
    
    private static MatchingCount matchingCount(int countOfMatch, boolean hasBonusNumber) {
        return new MatchingCount(countOfMatch, hasBonusNumber);
    }
}
