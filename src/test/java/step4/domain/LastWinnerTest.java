package step4.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LastWinnerTest {

    @Test
    void 로또_등수_확인() {
        Lotto lotto = new Lotto(List.of(3, 4, 5, 6, 7, 8));
        LastWinner lastWinner = new LastWinner(List.of(1, 2, 3, 4, 5, 6), 7);

        Assertions.assertThat(lastWinner.getPrizeByComparingWithLotto(lotto)).isEqualTo(Prize.FOUR_PRIZE);
    }

    @Test
    void 로또가_5등_일경우() {
        Lotto lotto = new Lotto(List.of(1, 3, 4, 5, 6, 7));
        LastWinner lastWinner = new LastWinner(List.of(1, 2, 3, 4, 5, 6), 7);

        Assertions.assertThat(lastWinner.getPrizeByComparingWithLotto(lotto)).isEqualTo(Prize.FIVE_BONUS_PRIZE);
    }
}
