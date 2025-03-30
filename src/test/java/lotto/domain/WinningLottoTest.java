package lotto.domain;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {
    static Stream<Arguments> provideLottoTestCases() {
        return Stream.of(
            Arguments.of(List.of(1, 2, 3, 4, 5, 6), PrizeLevel.FIRST),
            Arguments.of(List.of(1, 2, 3, 4, 5, 7), PrizeLevel.SECOND),
            Arguments.of(List.of(1, 2, 3, 4, 6, 8), PrizeLevel.THIRD),
            Arguments.of(List.of(1, 2, 3, 4, 8, 9), PrizeLevel.FOURTH),
            Arguments.of(List.of(1, 2, 3, 7, 8, 10), PrizeLevel.FIFTH),
            Arguments.of(List.of(7, 8, 9, 10, 11, 12), PrizeLevel.NO_PRIZE)
        );
    }

    @ParameterizedTest
    @MethodSource("provideLottoTestCases")
    @DisplayName("로또 번호 일치 개수 검증")
    void countMatchingNumbers_다양한_케이스_검증(List<Integer> numbers, PrizeLevel expectedLevel) {
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        PrizeLevel actualLevel = winningLotto.countMatchingNumbers(new Lotto(numbers));

        assertThat(actualLevel).isEqualTo(expectedLevel);
    }
}
