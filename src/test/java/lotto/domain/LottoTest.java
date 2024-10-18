package lotto.domain;

import lotto.enumeration.Rank;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    void 당첨번호와_로또번호의_일치_개수_총합() {
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);
        assertThat(lotto.rank(new InputNumber("1, 2, 3, 4, 5, 6", "7"))).isEqualTo(Rank.FIRST);
    }
}
