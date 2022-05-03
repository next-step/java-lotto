package lotto.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class WinnerTest {
    @Test
    void 당첨_테스트() {
        Lotto lotto = new Lotto(1, 3, 5, 6, 7, 8);
        Winner winner = new Winner(2, 4, 5, 6, 7, 8);

        assertThat(winner.findWinner(lotto)).isEqualTo(4);
    }
}
