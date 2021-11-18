package step2.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottosTest {

    private Lottos lottos;

    @BeforeEach
    void init() {
        lottos = new Lottos(
            Arrays.asList(1, 2, 3, 4, 5, 6),
            Arrays.asList(6, 7, 8, 9, 10, 11),
            Arrays.asList(6, 7, 8, 12, 13, 14),
            Arrays.asList(16, 17, 18, 19, 20, 21)
        );
    }

    @Test
    void illegalArgumentException_moneyIsLessThan0() {
        Lottos lottos = new Lottos(1000);
        assertThatThrownBy(() -> new Lottos(-1))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getWinnerCount() {
        Lotto sixMatch = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto noneMatch = new Lotto(Arrays.asList(40, 41, 42, 43, 44, 45));

        Map<Integer, Integer> sixWinner = lottos.getWinners(sixMatch);
        assertEquals(1, sixWinner.get(6));
        assertEquals(0, sixWinner.get(5));
        assertEquals(0, sixWinner.get(4));
        assertEquals(0, sixWinner.get(3));

        Map<Integer, Integer> noneWinner = lottos.getWinners(noneMatch);
        assertEquals(0, noneWinner.get(6));
        assertEquals(0, noneWinner.get(5));
        assertEquals(0, noneWinner.get(4));
        assertEquals(0, noneWinner.get(3));
    }

    @Test
    void getYield() {
        Lotto threeMatch = new Lotto(Arrays.asList(1, 2, 3, 30, 31, 32));

        double yield = lottos.getYield(threeMatch);
        double ans = Math.round(yield * 100) / 100.0;
        assertEquals(0.35, ans);
    }
}
