package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class WinningLottoTest {


    @Test
    void bonus() {
        List<Lotto> lottos = new ArrayList<>();
        Lotto lotto = new Lotto("1, 2, 3, 4, 5, 7");
        lottos.add(lotto);

        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6",7);

        Assertions.assertThat(winningLotto.matchBonus(lotto)).isTrue();

    }

    @Test
    void match() {
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6",7);
        Rank result6 = winningLotto.match(new Lotto("1,2,3,4,5,6"));
        Assertions.assertThat(result6).isEqualTo(Rank.FIRST);

        Rank result5 = winningLotto.match(new Lotto("1,2,3,4,5,7"));
        Assertions.assertThat(result5).isEqualTo(Rank.SECOND);
    }

    @Test
    void matchCount() {
        List<Lotto> lottos = new ArrayList<>();
        Lotto lotto1 = new Lotto("1, 2, 3, 4, 5, 6");
        Lotto lotto2 = new Lotto("1, 2, 3, 4, 5, 7");
        lottos.add(lotto1);
        lottos.add(lotto2);

        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6",7);

        Assertions.assertThat(winningLotto.matchRank(lottos,Rank.SECOND)).isEqualTo(1);
        Assertions.assertThat(winningLotto.matchRank(lottos,Rank.FIRST)).isEqualTo(1);

    }

}
