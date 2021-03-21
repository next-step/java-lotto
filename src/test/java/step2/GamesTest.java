package step2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Games;
import step2.domain.Seed;

public class GamesTest {

    @DisplayName("한 게임 당 1000원이고 시드머니가 14000이면 14게임")
    @Test
    void gameSize() {
        Games games = new Games();
        Seed seed = new Seed(14000);
        games.init(seed, 1000);
        assertEquals(14, games.size());
    }
}
