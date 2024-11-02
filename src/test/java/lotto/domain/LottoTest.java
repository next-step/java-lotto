
package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    void _1_45_사이_값만_입력_가능() {

        assertThatThrownBy(() ->
                new Lotto(Set.of(1, 2, 3, 4, 5, 66))
        ).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void 당첨_순위() {
        Lotto lotto = new Lotto(Set.of(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(Set.of(1, 2, 3, 4, 5, 7));

        assertThat(lotto.getLottoRank(winningLotto))
                .isEqualTo(LottoRank.FIVE_MATCH);
    }

    @Test
    void 중복_입력_불가() {
        assertThatThrownBy(() ->
                new Lotto(Set.of(1, 2, 3, 4, 5, 5))
        ).isInstanceOf(IllegalArgumentException.class);
    }

}