package domain;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGamesTest {

    @Test
    void makeLottoAuto() {
        Lottos lottos = new Lottos();
        assertThat(new LottoGames(100, lottos)
                .getLottos().getNumOfLottos()).isEqualTo(100);
    }

    @Test
    void makeLottoAuto2() {
        Lottos lottos = new Lottos();
        Set<LottoNo> onelotto = new HashSet<>(Arrays
                .asList(new LottoNo(1), new LottoNo(2)
                        , new LottoNo(3), new LottoNo(4)
                        , new LottoNo(5), new LottoNo(6)));

        lottos.addLotto(new Lotto(onelotto));
        lottos.addLotto(new Lotto(onelotto));
        lottos.addLotto(new Lotto(onelotto));

        assertThat(new LottoGames(100, lottos)
                .getLottos().getNumOfLottos()).isEqualTo(103);
    }

    @Test
    void makeLottoAuto3() {
        Lottos lottos = new Lottos();
        Set<LottoNo> onelotto = new HashSet<>(Arrays
                .asList(new LottoNo(1), new LottoNo(2)
                        , new LottoNo(3), new LottoNo(4)
                        , new LottoNo(5), new LottoNo(6)));

        lottos.addLotto(new Lotto(onelotto));
        lottos.addLotto(new Lotto(onelotto));
        lottos.addLotto(new Lotto(onelotto));

        assertThat(new LottoGames(0, lottos)
                .getLottos().getNumOfLottos()).isEqualTo(3);
    }
}
