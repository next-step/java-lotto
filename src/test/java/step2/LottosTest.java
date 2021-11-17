package step2;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
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
        Lotto threeMatch = new Lotto(Arrays.asList(6, 7, 8, 44, 45));
        Lotto noneMatch = new Lotto(Arrays.asList(40, 41, 42, 43, 44, 45));

        assertEquals(1, lottos.getWinnerCount(6, sixMatch));
        assertEquals(0, lottos.getWinnerCount(5, sixMatch));
        assertEquals(2, lottos.getWinnerCount(3, threeMatch));
        assertEquals(0, lottos.getWinnerCount(6, noneMatch));
    }
}
