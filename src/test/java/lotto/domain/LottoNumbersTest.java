package lotto.domain;

import static lotto.domain.strategy.NumberGenerateStrategy.*;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumbersTest {
    @DisplayName("로또 갯수만큼 로또 번호들을 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = { 0, 1, 10, 5})
    void of(int lottoCount) {
        assertThat(LottoNumbers.of(RANDOM, lottoCount).count()).isEqualTo(lottoCount);
    }

    @DisplayName("로또번호 갯수를 리턴한다.")
    @ParameterizedTest
    @MethodSource("countSet")
    void count(LottoNumbers numbers, int expectedCount) {
        assertThat(numbers.count()).isEqualTo(expectedCount);
    }

    @DisplayName("번호목록이 일치한다면 true 를 리턴하고 아니라면 false 를 리턴한다.")
    @ParameterizedTest
    @MethodSource("equalsSet")
    void equals(LottoNumbers numbers, LottoNumbers other, boolean expected) {
        assertThat(numbers.equals(other)).isEqualTo(expected);
    }

    @DisplayName("특정한 갯수만큼 당첨번호와 일치하는 로또번호들을 리턴한다.")
    @ParameterizedTest
    @MethodSource("matchSet")
    void match(LottoNumbers actual, Number luckyNumber, int matchCount, LottoNumbers expected) {
        assertThat(actual.match(luckyNumber, matchCount)).isEqualTo(expected);
    }

    private static Stream<Arguments> countSet() {
        return Stream.of(
            Arguments.arguments(lottoNumbers(number(1, 2, 3, 4, 5, 6)), 1),   
            Arguments.arguments(lottoNumbers(), 0),   
            Arguments.arguments(lottoNumbers(number(2, 34, 24, 6, 7, 9), number(11, 34, 24, 6, 7, 9)), 2)   
        );
    }

    private static Stream<Arguments> equalsSet() {
        return Stream.of(
                Arguments.arguments(
                        lottoNumbers(number(1, 2, 3, 4, 5, 6), number(5, 6, 7, 8, 9, 10)),
                        lottoNumbers(number(1, 2, 3, 4, 5, 6), number(5, 6, 7, 8, 9, 10)),
                        true
                ),
                Arguments.arguments(
                        lottoNumbers(number(1, 2, 3, 4, 5, 6), number(5, 6, 7, 8, 9, 10)),
                        lottoNumbers(number(5, 6, 7, 8, 9, 10), number(1, 2, 3, 4, 5, 6)),
                        true
                ),
                Arguments.arguments(
                        lottoNumbers(number(1, 2, 3, 4, 5, 6), number(5, 6, 7, 8, 9, 10)),
                        lottoNumbers(number(5, 6, 7, 8, 9, 10)),
                        false
                ),
                Arguments.arguments(
                        lottoNumbers(number(5, 6, 7, 8, 9, 10)),
                        lottoNumbers(),
                        false
                )
        );
    }
    
    private static Stream<Arguments> matchSet() {
        return Stream.of(
            Arguments.arguments(
                    lottoNumbers(number(1, 2, 3, 4, 5, 6), number(5, 6, 7, 8, 9, 10)),
                    number(5, 6, 11, 12, 13, 14),
                    3,
                    lottoNumbers()
            ),
            Arguments.arguments(
                    lottoNumbers(number(1, 2, 3, 4, 5, 6), number(5, 6, 7, 8, 9, 10)),
                    number(5, 6, 7, 12, 13, 14),
                    3,
                    lottoNumbers(number(5, 6, 7, 8, 9, 10))
            ),
            Arguments.arguments(
                    lottoNumbers(number(1, 2, 3, 4, 5, 6), number(5, 6, 7, 8, 9, 10)),
                    number(3, 4, 5, 6, 7, 8),
                    4,
                    lottoNumbers(number(1, 2, 3, 4, 5, 6), number(5, 6, 7, 8, 9, 10))
            )
        );
    }

    private static LottoNumbers lottoNumbers(Number... numbers) {
        return new LottoNumbers(Arrays.stream(numbers).collect(Collectors.toList()));
    }
    
    private static Number number(int... numbers) {
        return new Number(Arrays.stream(numbers).boxed().collect(Collectors.toList()));
    }

}
