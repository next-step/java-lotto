package edu.nextstep.camp.lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {
    static Stream<Arguments> parseLotto1To6AsList() {
        return Stream.of(
            Arguments.of(
                    List.of(1, 2, 3, 4, 5, 6)
            )
        );
    }

    @ParameterizedTest(name = "create from list: {arguments}")
    @MethodSource("parseLotto1To6AsList")
    public void createFromList(List<Integer> numbers) {
        assertThat(Lotto.fromIntegers(numbers))
                .isEqualTo(Lotto.fromIntegers(List.of(1, 2, 3, 4, 5, 6)));
        assertThat(Lotto.fromLottoNumbers(numbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toSet())
        )).isEqualTo(Lotto.fromIntegers(List.of(1, 2, 3, 4, 5, 6)));
    }

    static Stream<Arguments> parseLottoInvalid() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5)),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6, 7)),
                Arguments.of(List.of(1, 2, 3, 4, 5, 1))
        );
    }

    @ParameterizedTest(name = "create failed from list: {arguments}")
    @NullAndEmptySource
    @MethodSource("parseLottoInvalid")
    public void createFailedFromList(List<Integer> numbers) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Lotto.fromIntegers(numbers))
                .withMessageContaining("size of numbers must be");
    }

    @ParameterizedTest(name = "create from list: {arguments}")
    @MethodSource("parseLotto1To6AsList")
    public void collect(List<Integer> numbers) {
        assertThat(Lotto.fromIntegers(numbers).collect())
                .containsExactly("1", "2", "3", "4", "5", "6");
    }

    static Stream<Arguments> parseMatched() {
        return Stream.of(
                Arguments.of(Lotto.fromIntegers(List.of(1, 2, 3, 4, 5, 6)), 6),
                Arguments.of(Lotto.fromIntegers(List.of(1, 2, 3, 43, 44, 45)), 3),
                Arguments.of(Lotto.fromIntegers(List.of(40, 41, 42, 43, 44, 45)),0)
        );
    }

    @ParameterizedTest(name = "check matched count with FixedLotto(1,2,3,4,5,6): {arguments}")
    @MethodSource("parseMatched")
    public void matchedCount() {
        final Lotto testLotto = Lotto.fromIntegers(List.of(1, 2, 3, 4, 5, 6));
        assertThat(testLotto.matchedCount(testLotto)).isEqualTo(6);
    }

    @Test
    @DisplayName("check given number is in lotto numbers")
    public void contains() {
        Lotto lotto = Lotto.fromIntegers(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.contains(LottoNumber.of(6))).isTrue();
        assertThat(lotto.contains(LottoNumber.of(7))).isFalse();
    }
}
