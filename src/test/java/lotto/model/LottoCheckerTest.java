package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoCheckerTest {
    @Test
    @DisplayName("기본 생성 테스트")
    public void create() {
        LottoChecker checker = new LottoChecker(new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6))));

        assertThat(checker).hasFieldOrProperty("winningLotto");
    }

    @ParameterizedTest
    @DisplayName("check 결과 리턴")
    @MethodSource("provideCheck")
    public void check(List<Integer> numbers, LottoPlace lottoPlace) {
        LottoChecker checker = new LottoChecker(new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6))));

        assertThat(checker.check(new Lotto(new LottoNumbers(numbers)))).isEqualTo(lottoPlace);
    }

    public static Stream<Arguments> provideCheck() {
        return Stream.of(
            Arguments.arguments(Arrays.asList(1, 2, 3, 4, 5, 6), LottoPlace.FIRST),
            Arguments.arguments(Arrays.asList(1, 2, 3, 4, 5, 9), LottoPlace.SECOND),
            Arguments.arguments(Arrays.asList(1, 2, 3, 4, 8, 9), LottoPlace.THIRD),
            Arguments.arguments(Arrays.asList(1, 2, 3, 7, 8, 9), LottoPlace.FOURTH),
            Arguments.arguments(Arrays.asList(1, 2, 10, 7, 8, 9), LottoPlace.LOSE),
            Arguments.arguments(Arrays.asList(1, 11, 10, 7, 8, 9), LottoPlace.LOSE),
            Arguments.arguments(Arrays.asList(12, 11, 10, 7, 8, 9), LottoPlace.LOSE)
        );
    }
}