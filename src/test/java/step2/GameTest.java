package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
    Winning winning;

    @BeforeEach
    void setUp() {
        Set<Integer> lotto = new HashSet<>();
        lotto.add(2);
        lotto.add(3);
        lotto.add(4);
        lotto.add(5);
        winning = new Winning(lotto);
    }

    @Test
    @DisplayName("동일한 개수 확인")
    void score() {
        Game game = new Game(5, 5);
        int score = game.score(winning);
        assertThat(score).isEqualTo(4);
    }
}
