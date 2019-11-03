package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    Set<Integer> lotto;

    @BeforeEach
    void setUp() {
        lotto = new HashSet<>();
        lotto.add(1);
        lotto.add(2);
        lotto.add(3);
        lotto.add(4);
        lotto.add(5);
    }

    @Test
    @DisplayName("동일한 개수 확인")
    void score() {
        Lotto.init(1, 5);
        Game game = new Game(5);
        assertThat(game.score(lotto)).isEqualTo(5);
    }
}
