package my.project.lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created : 2020-11-23 오후 2:06
 * Developer : Seo
 */
class LottosTest {
    // TODO
    @Test
    void name() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(LottoNumber.generate());
        assertThat(new Lottos(lottos)).isNotNull();
    }

}
