package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @Test
    void create() {
        Lottos lottos = new Lottos();
        assertThat(lottos).isEqualTo(new Lottos());
    }

    @Test
    void matchOfRanks() {
        Lottos lottos = new Lottos();
        Lotto lotto1 = new Lotto(Arrays.asList(1,2,3,4,5,6));
        lottos.addLotto(lotto1);

        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1,2,3,4,5,6), 7);

        assertThat(lottos.matchOfRanks(winningLotto)).isEqualTo(Collections.singletonList(Rank.FIRST));
    }

    @Test
    void groupByMatchRanks() {
        Lottos lottos = new Lottos();
        Lotto lotto1 = new Lotto((Arrays.asList(1,2,3,4,5,6)));
        Lotto lotto2 = new Lotto((Arrays.asList(1,2,3,4,5,7)));
        Lotto lotto3 = new Lotto((Arrays.asList(1,2,3,4,5,7)));

        lottos.addLotto(lotto1);
        lottos.addLotto(lotto2);
        lottos.addLotto(lotto3);

        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1,2,3,4,5,6), 7);

        assertThat(lottos.groupByMatchRanks(winningLotto)).isNotNull();
    }

    @Test
    void makeLottoTest() {
        Lottos lottos = new Lottos();
        List<Lotto> makeLotto = lottos.makeLotto(5000, 2);

        assertThat(makeLotto.size()).isEqualTo(3);
    }
}