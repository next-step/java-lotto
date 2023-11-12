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
        // given
        Game game = Game.byGameNumbers(Set.of(
                GameNumber.of(1), GameNumber.of(2), GameNumber.of(3),
                GameNumber.of(4), GameNumber.of(5), GameNumber.of(6)
        ));
        Game winningGame = Game.byGameNumbers(Set.of(
                GameNumber.of(4), GameNumber.of(5), GameNumber.of(6),
                GameNumber.of(7), GameNumber.of(8), GameNumber.of(9)
        ));

        // when
        game.match(winningGame);

        // then
        assertThat(game.matchCount()).isEqualTo(3);
    }
}
