package step2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import step2.domian.Lotto;

import java.util.List;

public class LottoTest {

    @Test
    void count_로또_두개의_같은숫자_갯수() {
        Lotto lastWinner = new Lotto(List.of(1, 2, 3, 4, 5));
        Lotto lotto = new Lotto(List.of(3, 4, 5, 6, 7));

        Assertions.assertThat(lotto.countSameNumber(lastWinner)).isEqualTo(3);
    }
}
