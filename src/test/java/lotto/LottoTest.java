package lotto;

import lotto.utils.GenerateLotto;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
public class LottoTest {

    private Lotto lotto;

    @Before
    public void setUp() {
        lotto = new Lotto(new GenerateLotto());
    }

    @Test
    public void 로또_번호를_지정해서_생성() {
        lotto.createLotto("1,2,3,4,5,6");
        assertThat(lotto.getLottoNumber().getNumbers()).isEqualTo(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    public void 로또_번호를_0개_맞추면_정상() {
        lotto.createLotto("1,2,3,4,5,6");
        lotto.calculatorMatchLottoNumber(new LottoNumber(new ArrayList<>(Arrays.asList(29, 30, 31, 32, 33, 34))));
        assertThat(lotto.isMatchPoint(0)).isTrue();
    }

    @Test
    public void 로또_번호를_하나_맞추면_정상() {
        lotto.createLotto("1,2,3,4,5,6");
        lotto.calculatorMatchLottoNumber(new LottoNumber(new ArrayList<>(Arrays.asList(1, 30, 31, 32, 33, 34))));
        assertThat(lotto.isMatchPoint(1)).isTrue();
    }

    @Test
    public void 로또_번호를_두개_맞추면_정상() {
        lotto.createLotto("1,2,3,4,5,6");
        lotto.calculatorMatchLottoNumber(new LottoNumber(new ArrayList<>(Arrays.asList(1, 2, 31, 32, 33, 34))));
        assertThat(lotto.isMatchPoint(2)).isTrue();
    }

    @Test
    public void 로또_번호를_세개_맞추면_정상() {
        lotto.createLotto("1,2,3,4,5,6");
        lotto.calculatorMatchLottoNumber(new LottoNumber(new ArrayList<>(Arrays.asList(1, 2, 3, 32, 33, 34))));
        assertThat(lotto.isMatchPoint(3)).isTrue();
    }

    @Test
    public void 로또_번호를_네개_맞추면_정상() {
        lotto.createLotto("1,2,3,4,5,6");
        lotto.calculatorMatchLottoNumber(new LottoNumber(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 33, 34))));
        assertThat(lotto.isMatchPoint(4)).isTrue();
    }

    @Test
    public void 로또_번호를_다섯개_맞추면_정상() {
        lotto.createLotto("1,2,3,4,5,6");
        lotto.calculatorMatchLottoNumber(new LottoNumber(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 34))));
        assertThat(lotto.isMatchPoint(5)).isTrue();
    }

    @Test
    public void 로또_번호를_모두_맞추면_정상() {
        lotto.createLotto("1,2,3,4,5,6");
        lotto.calculatorMatchLottoNumber(new LottoNumber(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))));
        assertThat(lotto.isMatchPoint(6)).isTrue();
    }

}
