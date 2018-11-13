package lotto;

import lotto.domain.Lotto;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
public class LottoTest {

    private Lotto lotto;

    @Before
    public void setUp() {
        lotto = new Lotto("1,2,3,4,5,6");
    }

    @Test
    public void 로또_번호를_지정해서_생성() {
        assertThat(lotto.getNumber()).isEqualTo(new ArrayList<>(asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    public void 로또_번호를_0개_맞추면_정상() {
        assertThat(lotto.isMatchNumber(new ArrayList<>(asList(29, 30, 31, 32, 33, 34)), 0)).isTrue();
    }

    @Test
    public void 로또_번호를_하나_맞추면_정상() {
        assertThat(lotto.isMatchNumber(new ArrayList<>(asList(1, 30, 31, 32, 33, 34)), 1)).isTrue();
    }

    @Test
    public void 로또_번호를_두개_맞추면_정상() {
        assertThat(lotto.isMatchNumber(new ArrayList<>(asList(1, 2, 31, 32, 33, 34)), 2)).isTrue();
    }

    @Test
    public void 로또_번호를_세개_맞추면_정상() {
        assertThat(lotto.isMatchNumber(new ArrayList<>(asList(1, 2, 3, 32, 33, 34)), 3)).isTrue();
    }

    @Test
    public void 로또_번호를_네개_맞추면_정상() {
        assertThat(lotto.isMatchNumber(new ArrayList<>(asList(1, 2, 3, 4, 33, 34)), 4)).isTrue();
    }

    @Test
    public void 로또_번호를_다섯개_맞추면_정상() {
        assertThat(lotto.isMatchNumber(new ArrayList<>(asList(1, 2, 3, 4, 5, 34)), 5)).isTrue();
    }

    @Test
    public void 로또_번호를_모두_맞추면_정상() {
        assertThat(lotto.isMatchNumber(new ArrayList<>(asList(1, 2, 3, 4, 5, 6)), 6)).isTrue();
    }

}
