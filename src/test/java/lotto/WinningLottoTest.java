package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class WinningLottoTest {

    @Test
    void match() {
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6");
        int result6 = winningLotto.match(new Lotto("1,2,3,4,5,6"));
        Assertions.assertThat(result6).isEqualTo(6);

        int result5 = winningLotto.match(new Lotto("1,2,3,4,5,7"));
        Assertions.assertThat(result5).isEqualTo(5);
    }

    @Test
    void matchCount() {
        List<Lotto> lottos = new ArrayList<>();
        Lotto lotto1 = new Lotto("1, 2, 3, 4, 5, 6");
        Lotto lotto2 = new Lotto("1, 2, 3, 4, 5, 7");
        lottos.add(lotto1);
        lottos.add(lotto2);

        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6");

        Assertions.assertThat(winningLotto.matchCount(lottos,5)).isEqualTo(1);
        Assertions.assertThat(winningLotto.matchCount(lottos,6)).isEqualTo(1);

    }

}
