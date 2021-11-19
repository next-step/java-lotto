package lotto;

import org.junit.jupiter.api.Test;
import lotto.domain.Lottos;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class LottosTest {
    @Test
    void checkMatchingTest() {
        List<Integer> winningNumber = Arrays.asList(1, 2, 3, 7, 8, 9);
        Lottos lottos = new Lottos(7000, () -> Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lottos.checkMatching(winningNumber)).isEqualTo(Arrays.asList(0, 0, 0, 7, 0, 0, 0));
    }

}
