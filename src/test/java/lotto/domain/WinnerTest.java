package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static lotto.domain.Rank.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class WinnerTest {

    @Test
    void 결과에는_모든_등수에_대한_당첨갯수가_있어야_한다() {
        LottoNumbers winner = new LottoNumbers(List.of(1, 2, 3, 4, 5, 6));
        Games games = new Games(List.of(winner, winner));

        LottoResult lottoResult = new LottoResult(winner, games);
        Set<Entry<Rank, Integer>> entrySet = lottoResult.countPerRank().entrySet();

        assertThat(entrySet).hasSize(values().length);
    }

    @ParameterizedTest
    @MethodSource("gamesAndEarningRate")
    void 전체_게임에_대한_수익률을_구할_수_있다(Games games, double expected) {
        LottoNumbers winner = new LottoNumbers(List.of(1, 2, 3, 4, 5, 6));
        LottoResult lottoResult = new LottoResult(winner, games);

        assertThat(lottoResult.calculateEarningRate()).isEqualTo(expected);
    }

    private static Stream<Arguments> gamesAndEarningRate() {
        double twice = 2.00;
        double breakEven = 1.00;
        double twoThird = 0.67;
        double half = 0.50;
        double oneThird = 0.33;

        return Stream.of(
                Arguments.arguments(new Games(getFourthAndNoneGame(2, 3)), twice),
                Arguments.arguments(new Games(getFourthAndNoneGame(1, 4)), breakEven),
                Arguments.arguments(new Games(getFourthAndNoneGame(2, 13)), twoThird),
                Arguments.arguments(new Games(getFourthAndNoneGame(1, 9)), half),
                Arguments.arguments(new Games(getFourthAndNoneGame(1, 14)), oneThird)
        );
    }

    private static List<LottoNumbers> getFourthAndNoneGame(int fourth, int none) {
        List<LottoNumbers> fourthGames = IntStream.range(0, fourth)
                .mapToObj(i -> new LottoNumbers((List.of(1, 2, 3, 7, 8, 9))))
                .collect(Collectors.toList());
        List<LottoNumbers> noneGames = IntStream.range(0, none)
                .mapToObj(i -> new LottoNumbers((List.of(1, 2, 7, 8, 9, 10))))
                .collect(Collectors.toList());
        fourthGames.addAll(noneGames);

        return fourthGames;
    }
}
