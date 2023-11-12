package src;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    private static final int SIZE_OF_LOTTO_GAME_NUMBER = 6;

    @Test
    void 게임당_중복없이_6개의_번호를_가질_수_있다() {
        // when
        Game game = Game.newGame();

        // then
        assertThat(game).isNotNull();
        assertThat(game.numberSize()).isEqualTo(SIZE_OF_LOTTO_GAME_NUMBER);
    }

    @Test
    void 몇개의_게임_번호가_당첨_번호와_매치되었는지_알_수_있다() {
        Game game = new Game(Set.of(1, 2, 3, 4, 5, 6));
        Game winningGame = new Game(Set.of(4, 5, 6, 7, 8, 9));

        game.match(winningGame);


        assertThat(game.matchCount()).isEqualTo(3);
    }
}
