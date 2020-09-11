package domain;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @Test
    void makeLottoAuto() {

        Lottos manual = new Lottos();
        assertThat( new Lottos(100,manual)
                .getNumOfLottos()).isEqualTo(100);
    }

    @Test
    void makeLottoAuto2() {
        Lottos manual = new Lottos();
        Set<LottoNo> onelotto = new HashSet<>(Arrays
                .asList(new LottoNo(1), new LottoNo(2)
                        , new LottoNo(3), new LottoNo(4)
                        , new LottoNo(5), new LottoNo(6)));

        manual.addLotto(new Lotto(onelotto));
        manual.addLotto(new Lotto(onelotto));
        manual.addLotto(new Lotto(onelotto));

        assertThat(new Lottos(100, manual)
                .getNumOfLottos()).isEqualTo(103);
    }

    @Test
    void makeLottoAuto3() {
        Lottos manual = new Lottos();
        Set<LottoNo> onelotto = new HashSet<>(Arrays
                .asList(new LottoNo(1), new LottoNo(2)
                        , new LottoNo(3), new LottoNo(4)
                        , new LottoNo(5), new LottoNo(6)));

        manual.addLotto(new Lotto(onelotto));
        manual.addLotto(new Lotto(onelotto));
        manual.addLotto(new Lotto(onelotto));

        assertThat(new Lottos(0, manual)
                .getNumOfLottos()).isEqualTo(3);
    }
}
