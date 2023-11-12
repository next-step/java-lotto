package src;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class GamesTest {

    @Test
    void 전체_게임의_수익률을_확인할_수_있다() {
        // given
        /**
         * 로또를 2(2000원)개 구매하고 4등 (5000원) 당첨 케이스
         */
        Game fourthPlaceGame = Game.byGameNumbers(Set.of(
                GameNumber.of(4), GameNumber.of(5), GameNumber.of(6),
                GameNumber.of(7), GameNumber.of(8), GameNumber.of(9)
        ));

        Game otherGame = Game.byGameNumbers(Set.of(
                GameNumber.of(45), GameNumber.of(44), GameNumber.of(43),
                GameNumber.of(42), GameNumber.of(41), GameNumber.of(40)
        ));
        Games games = new Games(List.of(fourthPlaceGame, otherGame));

        Game winningGame = Game.byGameNumbers(Set.of(
                GameNumber.of(1), GameNumber.of(2), GameNumber.of(3),
                GameNumber.of(4), GameNumber.of(5), GameNumber.of(6)
        ));
        double expectedProfitRate = 2.5;
        games.matchGames(winningGame);

        // when
        double profitRate = games.profitRate(1000L);

        // then
        assertThat(profitRate).isEqualTo(expectedProfitRate);
    }
}
