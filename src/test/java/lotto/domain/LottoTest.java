package lotto.domain;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
public class LottoTest {

    private Lotto lotto;

    @Before
    public void setUp() {
        lotto = new Lotto("1,2,3,4,5,6");
    }

    @Test
    public void 로또_번호를_세개_맞추면_정상() {
        assertThat(lotto.lottoOfRank(new Lotto("1,2,3,32,33,34"), Rank.FIFTH, 40)).isTrue();
    }

    @Test
    public void 로또_번호를_네개_맞추면_정상() {
        assertThat(lotto.lottoOfRank(new Lotto("1,2,3,4,33,34"), Rank.FOURTH, 40)).isTrue();
    }

    @Test
    public void 로또_번호를_다섯개_맞추면_정상() {
        assertThat(lotto.lottoOfRank(new Lotto("1,2,3,4,5,34"), Rank.THIRD, 40)).isTrue();
    }

    @Test
    public void 로또_번호를_모두_맞추면_정상() {
        assertThat(lotto.lottoOfRank(new Lotto("1,2,3,4,5,6"), Rank.FIRST, 40)).isTrue();
    }

}
