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

    @ParameterizedTest
    @NullAndEmptySource
    void 당첨번호는_필수다(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Game(input))
                .withMessage("당첨번호를 입력해 주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,,,3,4,5,6", "1,나,3,4,5,6"})
    @DisplayName("당첨 번호는 쉼표로 구분된 숫자만 입력 가능하다.")
    void 당첨_번호_확인(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Game(input))
                .withMessage("숫자만 입력할 수 있습니다.");
    }

    @ParameterizedTest
    @MethodSource("comparingIdenticalLottonumber")
    void 두_게임의_일치하는_로또번호_갯수를_확인한다(Game game1, Game game2, int expected) {
        int count = game1.countIdenticalLottonumber(game2);

        assertThat(count).isEqualTo(expected);
    }

    private static Stream<Arguments> comparingIdenticalLottonumber() {
        return Stream.of(
                Arguments.arguments(new Game(List.of(1, 2, 3, 4, 5, 6)), new Game(List.of(7, 8, 9, 10, 11, 12)), 0),
                Arguments.arguments(new Game(List.of(1, 2, 3, 4, 5, 6)), new Game(List.of(1, 10, 20, 30, 40, 45)), 1),
                Arguments.arguments(new Game(List.of(1, 2, 3, 4, 5, 6)), new Game(List.of(4, 5, 6, 7, 8, 9)), 3),
                Arguments.arguments(new Game(List.of(1, 2, 3, 4, 5, 6)), new Game(List.of(1, 2, 3, 4, 5, 6)), 6)
        );
    }

    @Test
    void 결과에는_모든_등수에_대한_당첨갯수가_있어야_한다() {
        Game winner = new Game(List.of(1, 2, 3, 4, 5, 6));
        Games games = new Games(winner, winner);

        LottoResult lottoResult = new LottoResult(winner, games);
        Set<Entry<Rank, Integer>> entrySet = lottoResult.countPerRank().entrySet();

        assertThat(entrySet).hasSize(values().length);
    }

    @ParameterizedTest
    @MethodSource("gamesAndPrize")
    void 전체_게임에_대한_상금을_구할_수_있다(Games games, int expected) {
        Game winner = new Game(List.of(1, 2, 3, 4, 5, 6));
        LottoResult lottoResult = new LottoResult(winner, games);

        assertThat(lottoResult.calculatePrize()).isEqualTo(expected);
    }

    private static Stream<Arguments> gamesAndPrize() {
        List<Integer> first = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> second = List.of(1, 2, 3, 4, 5, 7);
        List<Integer> third = List.of(1, 2, 3, 4, 7, 8);
        List<Integer> fourth = List.of(1, 2, 3, 7, 8, 9);
        List<Integer> none = List.of(1, 2, 7, 8, 9, 10);

        return Stream.of(
                Arguments.arguments(new Games(new Game(first)), FIRST.wins()),
                Arguments.arguments(new Games(new Game(second)), SECOND.wins()),
                Arguments.arguments(new Games(new Game(third)), THIRD.wins()),
                Arguments.arguments(new Games(new Game(fourth)), FOURTH.wins()),
                Arguments.arguments(new Games(new Game(none)), NONE.wins()),
                Arguments.arguments(
                        new Games(new Game(first), new Game(second)),
                        FIRST.wins() + SECOND.wins()
                ),
                Arguments.arguments(
                        new Games(new Game(third), new Game(fourth)),
                        THIRD.wins() + FOURTH.wins()
                ),
                Arguments.arguments(
                        new Games(new Game(none), new Game(first)),
                        NONE.wins() + FIRST.wins()
                )
        );
    }

    @ParameterizedTest
    @MethodSource("gamesAndEarningRate")
    void 전체_게임에_대한_수익률을_구할_수_있다(Games games, double expected) {
        Game winner = new Game(List.of(1, 2, 3, 4, 5, 6));
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

    private static Game[] getFourthAndNoneGame(int fourth, int none) {
        List<Game> fourthGames = IntStream.range(0, fourth)
                .mapToObj(i -> new Game((List.of(1, 2, 3, 7, 8, 9))))
                .collect(Collectors.toList());
        List<Game> noneGames = IntStream.range(0, none)
                .mapToObj(i -> new Game((List.of(1, 2, 7, 8, 9, 10))))
                .collect(Collectors.toList());
        fourthGames.addAll(noneGames);

        return fourthGames.toArray(Game[]::new);
    }
}
