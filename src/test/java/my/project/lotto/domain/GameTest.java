package my.project.lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created : 2020-11-23 오후 2:06
 * Developer : Seo
 */
class GameTest {
    private Game game;

    @BeforeEach
    void setUp() {
        this.game = new Game();
        game.game();
    }

    @DisplayName("1게임은 6개의 숫자를 가진다")
    @Test
    void whenHaveGame_shouldHaveSixNumbers() {
        assertThat(game.record().get()).hasSize(6);
    }

}
