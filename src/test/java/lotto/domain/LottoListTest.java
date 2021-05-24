package lotto.domain;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoListTest {
    @Test
    void 로또리스트는_로또리스_프로퍼티를_갖는다(){
        LottoList lottos = new LottoList();
        assertThat(lottos).hasFieldOrProperty("lottos");
    }
}
