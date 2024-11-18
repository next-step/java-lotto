package lotto.service;

import lotto.domain.Games;
import lotto.domain.LottoNumbers;
import lotto.domain.Rank;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LottoServiceTest {

    @ParameterizedTest
    @CsvSource({"1000, 1", "5000, 5", "10000, 10"})
    void purchase(int money, int expected) {
        LottoService lottoService = new LottoService();
        Games games = lottoService.purchaseLotto(money);

        assertThat(games.count()).isEqualTo(expected);
    }

    // @ParameterizedTest
    // @MethodSource("lottoNumbersListAndRanks")
    // void checkResult(List<LottoNumbers> lottoNumbersList, int bonusNumber, List<Rank> expected) {
    //     LottoService lottoService = new LottoService();
    //     LottoNumbers winner = new LottoNumbers(Set.of(1, 2, 3, 4, 5, 6));
    //     Games games = new Games(lottoNumbersList);
    //
    //     List<Rank> ranks = lottoService.checkResult(winner, games);
    //
    //     assertThat(ranks).hasSize(games.count());
    //     assertThat(ranks).containsExactlyElementsOf(expected);
    // }
    //
    // private static Stream<Arguments> lottoNumbersListAndRanks() {
    //     return Stream.of(
    //             arguments(
    //                     List.of(new LottoNumbers(Set.of(1,2,3,4,5,6))),
    //                     7,
    //                     List.of(Rank.FIRST)),
    //             arguments(
    //                     List.of(new LottoNumbers(Set.of(1,2,3,4,5,6)), new LottoNumbers(Set.of(1,2,3,4,5,7))),
    //                     7,
    //                     List.of(Rank.FIRST, Rank.SECOND)),
    //             arguments(
    //                     List.of(new LottoNumbers(Set.of(1,2,3,4,5,7)), new LottoNumbers(Set.of(1,2,3,4,5,8))),
    //                     7,
    //                     List.of(Rank.SECOND, Rank.THIRD)
    //             )
    //     );
    // }
}