package step2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Game;
import step2.domain.Number;

public class GameTest {

    @DisplayName("shuffle 게임 생성 테스트")
    @Test
    void generateGame() {
        int length = 6;
        Game game = new Game(length);

        Set<Number> numbers = new HashSet<>(game.numbers());

        assertEquals(length, numbers.size());
    }
}
