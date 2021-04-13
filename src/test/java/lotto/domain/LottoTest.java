package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LottoTest {

    private static Stream<Arguments> lottoParameters() {
        return Stream.of(
                arguments(Arrays.asList(1, 2, 3, 4, 5, 6), Rank.SECOND),
                arguments(Arrays.asList(2, 3, 4, 5, 6, 7), Rank.FIRST),
                arguments(Arrays.asList(3, 4, 5, 6, 7, 8), Rank.THIRD),
                arguments(Arrays.asList(4, 5, 6, 7, 8, 9), Rank.FOURTH),
                arguments(Arrays.asList(5, 6, 7, 8, 9, 10), Rank.FIFTH),
                arguments(Arrays.asList(6, 7, 8, 9, 10, 11), Rank.OTHER)
        );
    }

    @ParameterizedTest
    @MethodSource("lottoParameters")
    public void winningResult(List<Integer> inputNumbers, Rank expectRank) {
        // given
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(2, 3, 4, 5, 6, 7), 1);
        Lotto lotto = new Lotto(inputNumbers);

        // when
        Rank resultRank = lotto.winningResult(winningNumber);

        // then
        assertThat(resultRank).isEqualTo(expectRank);
    }

    @Test
    public void purchaseLotto() {
        // given
        Lottos lottos = new Lottos(14000);
        int expectSize = 14;

        // when
        int resultSize = lottos.size();

        // then
        assertThat(resultSize).isEqualTo(expectSize);
    }
}
