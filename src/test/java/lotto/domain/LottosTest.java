package lotto.domain;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import static lotto.domain.LottoFixture.*;
import static lotto.domain.LottoFixture.번호_0개_일치;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottosTest {
    @Test
    void 로또리스트는_로또스_프로퍼티를_갖는다(){
        Lottos lottos = new Lottos();
        assertThat(lottos).hasFieldOrProperty("lottos");
    }
    @Test
    void 두개의_Lottos_를_merge하는_기능을_제공한다() {
        Lottos one = new Lottos(Lists.newArrayList(번호_6개_일치, 번호_5개_일치, 번호_4개_일치, 번호_3개_일치));
        Lottos another = new Lottos(Lists.newArrayList(번호_2개_일치, 번호_1개_일치, 번호_0개_일치, 번호_0개_일치));
        Lottos merged = Lottos.merge(one, another);
        assertAll(
                () -> assertThat(merged.size()).isEqualTo(one.size() + another.size()),
                () -> assertThat(merged.containsAll(another)).isTrue(),
                () -> assertThat(merged.containsAll(one)).isTrue());
    }
}
