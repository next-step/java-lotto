package step3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import step3.domian.LastWinner;
import step3.domian.Lotto;

import java.util.List;

public class LastWinnerTest {

    @Test
    void 같은_숫자의_갯수_() {
        Lotto lotto = new Lotto(List.of(3, 4, 5, 6, 7, 8));
        LastWinner lastWinner = new LastWinner(List.of(1,2,3,4,5,6),7);

        Assertions.assertThat(lastWinner.countSameNumber(lotto)).isEqualTo(4);
    }

    @Test
    void 로또가_보너스볼을_가졌는지() {
        Lotto lotto = new Lotto(List.of(3, 4, 5, 6, 7, 8));
        LastWinner lastWinner = new LastWinner(List.of(1,2,3,4,5,6),7);

        Assertions.assertThat(lastWinner.isContainBonus(lotto)).isEqualTo(true);
    }
}
