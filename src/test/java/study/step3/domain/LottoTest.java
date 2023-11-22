package study.step3.domain;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @ParameterizedTest
    @MethodSource
    void 등수_테스트(List<Integer> lottoNumbers, List<Integer> winningNumbers, Integer bonusNumber, Rank rank) {
        Lotto lotto = new Lotto(lottoNumbers);
        Rank result = lotto.matches(new Lotto(winningNumbers), new LottoNumber(bonusNumber));
        assertThat(result).isEqualTo(rank);
    }

    private static Stream<Arguments> 등수_테스트() {
        return Stream.of(
            Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 8, 9, 10), 7, Rank.FIFTH),
            Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 8, 9), 7, Rank.FOURTH),
            Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 8), 7, Rank.THIRD),
            Arguments.of(List.of(1, 2, 3, 4, 5, 7), List.of(1, 2, 3, 4, 5, 6), 7, Rank.SECOND),
            Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 6), 7, Rank.FIRST)
        );
    }
}
