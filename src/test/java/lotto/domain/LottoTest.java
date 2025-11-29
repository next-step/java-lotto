package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    void 로또_지난_주_당첨번호_개수() {
        Lotto lotto = new Lotto(1,2,3,4,5,6);

        assertThat(lotto.determineRank(
                new Lotto(1,2,3,11,22,33), new LottoNumber(4)
        )).isEqualTo(LottoRank.FIFTH);
    }
}
