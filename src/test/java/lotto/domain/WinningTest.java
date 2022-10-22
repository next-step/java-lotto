package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningTest {
    @DisplayName("일치갯수와 보상과 로또번호들이 같다면 true 를 리턴하고 아니라면 false 를 리턴한다.")
    @ParameterizedTest
    @MethodSource("winningsSet")
    void equals(Winning winning, Winning other, boolean expected) {
        assertThat(winning.equals(other)).isEqualTo(expected);
    }

    @DisplayName("당첨된 로또 번호들의 갯수를 리턴한다.")
    @ParameterizedTest
    @MethodSource("numberCountSet")
    void numberCount(Winning winning, int expected) {
        assertThat(winning.numberCount()).isEqualTo(expected);
    }

    @DisplayName("당첨된 로또번호가 있다면 true 를 리턴하고 없다면 false 를 리턴한다.")
    @ParameterizedTest
    @MethodSource("existSet")
    void exist(Winning winning, boolean expected) {
        assertThat(winning.exist()).isEqualTo(expected);
    }

    private static Stream<Arguments> winningsSet() {
        return Stream.of(
                Arguments.arguments(
                        new Winning(Prize.FOURTH, lottoNumbers(lottoNumber(1, 2, 3, 4, 5, 6))),
                        new Winning(Prize.FOURTH, lottoNumbers(lottoNumber(1, 2, 3, 4, 5, 6))),
                        true
                ),
                Arguments.arguments(
                        new Winning(Prize.FOURTH, lottoNumbers(lottoNumber(1, 2, 3, 4, 5, 6))),
                        new Winning(Prize.THIRD, lottoNumbers(lottoNumber(1, 2, 3, 4, 5, 6))),
                        false
                ),
                Arguments.arguments(
                        new Winning(Prize.FOURTH, lottoNumbers(lottoNumber(1, 2, 3, 4, 5, 6))),
                        new Winning(Prize.FOURTH, lottoNumbers(lottoNumber(1, 2, 3, 4, 5, 7))),
                        false
                )
        );
    }

    private static Stream<Arguments> numberCountSet() {
        return Stream.of(
                Arguments.arguments(new Winning(Prize.FOURTH, lottoNumbers(lottoNumber(1, 2, 3, 4, 5, 6))), 1),
                Arguments.arguments(new Winning(Prize.FOURTH, lottoNumbers()), 0),
                Arguments.arguments(new Winning(Prize.FOURTH, lottoNumbers(
                                            lottoNumber(1, 2, 3, 4, 5, 6),
                                            lottoNumber(4, 5, 3, 4, 5, 6),
                                            lottoNumber(1, 7, 8, 4, 5, 6))),
                                    3)
        );
    }

    private static Stream<Arguments> existSet() {
        return Stream.of(
                Arguments.arguments(new Winning(Prize.FOURTH, lottoNumbers(lottoNumber(1, 2, 3, 4, 5, 6))), true),
                Arguments.arguments(new Winning(Prize.FOURTH, lottoNumbers(
                                            lottoNumber(1, 2, 3, 4, 5, 6),
                                            lottoNumber(10, 12, 23, 34, 35, 36))),
                                    true),
                Arguments.arguments(new Winning(Prize.FOURTH, lottoNumbers()), false),
                Arguments.arguments(new Winning(Prize.FOURTH, null), false)
            );
    }

    private static LottoNumber lottoNumber(Integer... numbers) {
        return new LottoNumber(Arrays.asList(numbers));
    }

    private static LottoNumbers lottoNumbers(LottoNumber... numbers) {
        return new LottoNumbers(Arrays.asList(numbers));
    }
}
