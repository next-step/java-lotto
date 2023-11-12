package src;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    private static final int SIZE_OF_LOTTO_GAME_NUMBER = 6;

    @Test
    void 게임당_6개의_번호를_가질_수_있다() {
        // when
        Game game = Game.newGame();

        // then
        assertThat(game).isNotNull();
        assertThat(game.numberSize()).isEqualTo(SIZE_OF_LOTTO_GAME_NUMBER);
    }
}
