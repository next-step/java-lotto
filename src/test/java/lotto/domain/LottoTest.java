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

    private static Stream<Arguments> winningResultParameters() {
        return Stream.of(
                arguments(Arrays.asList(1, 2, 3, 4, 5, 6), Rank.FIRST),
                arguments(Arrays.asList(1, 2, 3, 4, 5, 7), Rank.THIRD)
        );
    }

    @ParameterizedTest
    @MethodSource("winningResultParameters")
    public void winningResult(List<Integer> inputNumbers, Rank expectRank) {
        // given
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(inputNumbers);

        // when
        Rank resultRank = lotto.winningResult(winningNumber);

        // then
        assertThat(resultRank).isEqualTo(expectRank);
    }


    @Test
    public void winningResults() {
        // given
        List<Rank> expectRanks = Arrays.asList(Rank.FIRST, Rank.OTHER);
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        WinningNumber winningNumber = new WinningNumber(winningNumbers);
        Lotto firstLotto = new Lotto(winningNumbers);
        Lotto otherLotto = new Lotto(Arrays.asList(8, 9, 10, 11, 12, 13));
        List<Lotto> lottoList = Arrays.asList(firstLotto, otherLotto);
        Lottos lottos = new Lottos(lottoList);

        // when
        List<Rank> resultRanks = lottos.winningResults(winningNumber);

        // then
        assertThat(resultRanks).isEqualTo(expectRanks);
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

    @Test
    public void manualLottos() {
        // given
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12));
        Lottos expectLottos = new Lottos(Arrays.asList(lotto1, lotto2));

        // when
        Lottos resultLottos = new Lottos(2000, Arrays.asList(lotto1, lotto2));

        // then
        assertThat(resultLottos).isEqualTo(expectLottos);
    }
}
